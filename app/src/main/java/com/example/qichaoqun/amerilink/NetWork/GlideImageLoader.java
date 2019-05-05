package com.example.qichaoqun.amerilink.NetWork;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * @author qichaoqun
 * @date 2018/8/28
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Log.i("图片加载其中的path的值是多少", "displayImage: "+path);
        Glide.with(context).load(String.valueOf(path).trim()).skipMemoryCache(false).into(imageView);
    }
}
