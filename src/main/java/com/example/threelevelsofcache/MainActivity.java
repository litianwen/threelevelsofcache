package com.example.threelevelsofcache;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 三级缓存工具类的调用测试
 * 1.创建三级缓存类的对象，传入上下文和图片名字
 * 2.调用三级缓存类的对象的loadImage方法，
 * 传入两个参数，第一个参数是URL地址，第二个参数是回调接口，在回调接口内可以接收到根据URL地址下载到的Bitmap对象
 */
public class MainActivity extends AppCompatActivity {

    //定义布局的控件
    ImageView imageView;
    //定义三级缓存工具类
    ImageLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShowUtils.DEBUG = false;
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.main_iv);
        loader = new ImageLoader(this, "test3");//创建文件夹
    }

    public void start(View v) {
        loader.loadImage("http://p3.so.qhmsg.com/bdr/326__/t018da60b972e086a1d.jpg", new ImageLoader.ImageLoadListener() {
            @Override
            public void loadImage(Bitmap bmp) {
                imageView.setImageBitmap(bmp);
            }
        });
    }
}
