package com.example.fragment_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {

    //하던거
    //https://choheeis.github.io/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C/2020/03/01/BottomNavigation.html

    //하던거2
    //https://itstudy-mary.tistory.com/190

    //하던거3
    //https://everybody-yeah.tistory.com/6

    //참고 링크
    //https://blue-ilike.tistory.com/entry/Android-Studio-%EB%B0%94%ED%85%80-%EB%84%A4%EB%B9%84%EA%B2%8C%EC%9D%B4%EC%85%98-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-Bottom-Navigation


    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView=findViewById(R.id.bottom_navigation);

        //첫 화면 띄우기
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container,new Home()).commit();

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Home()).commit();
                        break;
                    case R.id.find_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Find()).commit();
                        break;
                    case R.id.write_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Write()).commit();
                        break;
                    case R.id.myPage_item:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Mypage()).commit();
                        break;

                }


                return true;
            }
        });

    }
}