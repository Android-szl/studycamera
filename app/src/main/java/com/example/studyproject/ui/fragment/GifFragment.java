package com.example.studyproject.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.studyproject.base.BaseFragment;
import com.example.studyproject.databinding.GifFragmentBinding;
import com.example.studyproject.ui.adapter.PhotoAdapter;
import com.example.studyproject.util.gifmaker.GifUtil;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName GifFragment
 * @Author 史正龙
 * @date 2022.02.25 17:14
 */
public class GifFragment extends BaseFragment<GifFragmentBinding> {

    private List<Bitmap> pics = new ArrayList<>();
    private int delayTime;
    private AlertDialog alertDialog;
    private PhotoAdapter adapter;
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

        adapter = new PhotoAdapter(requireContext(), pics);
        binding.gifRecycle.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        binding.gifRecycle.setAdapter(adapter);
        //获取间隔时长
        delayTime = binding.delayBar.getProgress();

        //从相册获取图片
        adapter.setmListener((view12, position) -> photoPick());

        binding.delayBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                delayTime = i;
                binding.delayText.setText(MessageFormat.format("帧间隔时长：{0}秒", i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //制作
        binding.generate.setOnClickListener(view1 -> {
            alertDialog.show();
            new Thread(() -> {
                String file_name = Objects.requireNonNull(binding.fileText.getText()).toString();
                GifUtil gifUtil = new GifUtil();
                String path = gifUtil.createGif(pics, TextUtils.isEmpty(file_name) ? "demo" : file_name, delayTime, requireContext());
                requireActivity().runOnUiThread(() -> {
                    file = new File(path);
                    handler.sendEmptyMessageAtTime(0, 1000);
                });
            }).start();
        });

        binding.clear.setOnClickListener(view1 -> {
            clearData();
        });
    }

    private void clearData() {
        pics.clear();
        adapter.setList(null);
    }


    //相册选取图片
    public void photoPick() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 0x21);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            Uri localUri = data.getData();
            String[] arrayOfString = {"_data"};
            Cursor localCursor = requireContext().getContentResolver().query(localUri, arrayOfString, null, null, null);
            localCursor.moveToFirst();
            @SuppressLint("Range") String str = localCursor.getString(localCursor.getColumnIndex(arrayOfString[0]));
            Bitmap bitmap = BitmapFactory.decodeFile(str);
            localCursor.close();
            pics.add(bitmap);
            adapter.setList(pics);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        alertDialog.dismiss();
    }
}
