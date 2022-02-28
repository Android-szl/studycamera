package com.example.studyproject.ui.fragment;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.studyproject.R;
import com.example.studyproject.base.BaseFragment;
import com.example.studyproject.databinding.DialogItemBinding;
import com.example.studyproject.databinding.GifFragmentBinding;
import com.example.studyproject.ui.adapter.FullyGridLayoutManager;
import com.example.studyproject.ui.adapter.GridImageAdapter;
import com.example.studyproject.util.gifmaker.GifUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName GifFragment
 * @Author 史正龙
 * @date 2022.02.25 17:14
 */
public class GifFragment extends BaseFragment<GifFragmentBinding> {
    private int maxSelectNum = 9;
    private List<LocalMedia> pics = new ArrayList<>();
    private int delayTime;
    private AlertDialog alertDialog;
    private GridImageAdapter adapter;
    private PopupWindow pop;
    private File file;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 0) {
                alertDialog.dismiss();
                Toast.makeText(requireContext(), "制作成功已保存到相册", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.fromFile(file);
                requireActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            } else {
                alertDialog.dismiss();
            }
            return false;
        }
    });


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.gifTitle.titleTv.setText("GIF动图制作");

        alertDialog = new AlertDialog.Builder(requireContext()).setView(new ProgressBar(requireContext()))
                .setMessage("正在生成gif图片").create();

        adapter = new GridImageAdapter(requireContext(), onAddPicClickListener);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false);
        binding.gifRecycle.setLayoutManager(manager);
        adapter.setList(pics);
        adapter.setSelectMax(maxSelectNum);
        binding.gifRecycle.setAdapter(adapter);
        adapter.setOnItemClickListener((position, v) -> {
            if (pics.size() > 0) {
                LocalMedia media = pics.get(position);
                String pictureType = media.getPictureType();
                int mediaType = PictureMimeType.pictureToVideo(pictureType);
                switch (mediaType) {
                    case 1:
                        // 预览图片 可自定长按保存路径
                        //PictureSelector.create(MainActivity.this).externalPicturePreview(position, "/custom_file", selectList);
                        PictureSelector.create(requireActivity()).externalPicturePreview(position, pics);
                        break;
                    case 2:
                        // 预览视频
                        PictureSelector.create(requireActivity()).externalPictureVideo(media.getPath());
                        break;
                    case 3:
                        // 预览音频
                        PictureSelector.create(requireActivity()).externalPictureAudio(media.getPath());
                        break;
                }
            }
        });

        //制作
        binding.generate.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            DialogItemBinding dBinding;
            dBinding = DialogItemBinding.inflate(getLayoutInflater());
            builder.setView(dBinding.getRoot());
            AlertDialog dialog = builder.show();
            delayTime = dBinding.timeSeek.getProgress();

            dBinding.timeSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    delayTime = i;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            dBinding.saveBtn.setOnClickListener(v1 -> {
                Toast.makeText(requireContext(), "保存成功", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                alertDialog.show();
                new Thread(() -> {
                    String file_name = Objects.requireNonNull(dBinding.nameEt.getText()).toString();
                    GifUtil gifUtil = new GifUtil();
                    String path = gifUtil.createGif(pics, TextUtils.isEmpty(file_name) ? "demo" : file_name, delayTime, requireContext());
                    requireActivity().runOnUiThread(() -> {
                        file = new File(path);
                        handler.sendEmptyMessageAtTime(0, 1000);
                    });
                }).start();
            });

            dBinding.btnCancel.setOnClickListener(view2 -> dialog.dismiss());
        });

        binding.settingBtn.setOnClickListener(view1 -> Toast.makeText(requireContext(), "点尼玛，滚！！！", Toast.LENGTH_SHORT).show());
    }

    @SuppressLint("CheckResult")
    private final GridImageAdapter.onAddPicClickListener onAddPicClickListener = () -> {
        //获取写的权限
        RxPermissions rxPermission = new RxPermissions(requireActivity());
        rxPermission.requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(permission -> {
                    if (permission.granted) {// 用户已经同意该权限
                        //第一种方式，弹出选择和拍照的dialog
                        showPop();
                    } else {
                        Toast.makeText(requireContext(), "拒绝", Toast.LENGTH_SHORT).show();
                    }
                });
    };


    private void showPop() {
        View bottomView = View.inflate(requireContext(), R.layout.layout_bottom_dialog, null);
        TextView mAlbum = bottomView.findViewById(R.id.tv_album);
        TextView mCamera = bottomView.findViewById(R.id.tv_camera);
        TextView mCancel = bottomView.findViewById(R.id.tv_cancel);

        pop = new PopupWindow(bottomView, -1, -2);
        pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        WindowManager.LayoutParams lp = requireActivity().getWindow().getAttributes();
        lp.alpha = 0.5f;
        requireActivity().getWindow().setAttributes(lp);
        pop.setOnDismissListener(() -> {
            WindowManager.LayoutParams lp1 = requireActivity().getWindow().getAttributes();
            lp1.alpha = 1f;
            requireActivity().getWindow().setAttributes(lp1);
        });
        pop.setAnimationStyle(R.style.main_menu_photo_anim);
        pop.showAtLocation(requireActivity().getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);

        View.OnClickListener clickListener = view -> {
            switch (view.getId()) {
                case R.id.tv_album:
                    //相册
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(maxSelectNum)
                            .minSelectNum(1)
                            .imageSpanCount(4)
                            .selectionMode(PictureConfig.MULTIPLE)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    break;
                case R.id.tv_camera:
                    //拍照
                    PictureSelector.create(this)
                            .openCamera(PictureMimeType.ofImage())
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    break;
                case R.id.tv_cancel:
                    //取消
                    closePopupWindow();
                    break;
            }
            closePopupWindow();
        };

        mAlbum.setOnClickListener(clickListener);
        mCamera.setOnClickListener(clickListener);
        mCancel.setOnClickListener(clickListener);
    }

    public void closePopupWindow() {
        if (pop != null && pop.isShowing()) {
            pop.dismiss();
            pop = null;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<LocalMedia> images;
        if (resultCode == RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {// 图片选择结果回调
                images = PictureSelector.obtainMultipleResult(data);
                pics.addAll(images);

                //selectList = PictureSelector.obtainMultipleResult(data);
                // 例如 LocalMedia 里面返回三种path
                // 1.media.getPath(); 为原图path
                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                adapter.setList(pics);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        alertDialog.dismiss();
    }
}
