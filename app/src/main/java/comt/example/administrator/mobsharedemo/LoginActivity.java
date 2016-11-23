package comt.example.administrator.mobsharedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,PlatformActionListener{

    private ImageView qq,chat,weibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        qq = (ImageView) findViewById(R.id.activity_login_qq);
        chat = (ImageView) findViewById(R.id.activity_login_weibo);
        weibo = (ImageView) findViewById(R.id.activity_login_weibo);

        qq.setOnClickListener(this);
        chat.setOnClickListener(this);
        weibo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.activity_login_qq:
                QZone qq = new QZone(this);
                login(qq);
            break;
            case R.id.activity_login_weibo:
                SinaWeibo weibo = new SinaWeibo(this);
                login(weibo);
            break;
            case R.id.activity_login_weichat:
                Wechat wechat = new Wechat(this);
                login(wechat);
            break;
        }

    }

    public void  login(Platform platform){

        String userId = platform.getDb().getUserId();

        if (userId != null && !userId.equals("")){
           //   登陆成功 直接跳转
            Log.e("TAG", "login: "+userId);
        }else {

            platform.setPlatformActionListener(this);
            platform.showUser(null);
        }
//        platform.authorize();
        Log.e("TAG", "login: "+userId);
    }


    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

        if (i == Platform.ACTION_AUTHORIZING){

        }else if (i == Platform.ACTION_USER_INFOR){
            //要数据不要功能
            for (String s : hashMap.keySet()) {
                String s1 = hashMap.get(s).toString();
                Log.e("获取用户数据", "\nonComplete:  key："+s+" values:"+s1);
            }
            
        }

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }
}
