package com.example.fragment_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

//BottomNavigationView를 위한 import
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


    //바텀네비게이션 뷰
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView=findViewById(R.id.bottom_navigation);

        //첫 화면 띄우기
        //프래그먼트의 경우, commit()함수로 적용시점을 명시해야함
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container,new Home()).commit();

        //bottom navigationview 안의 아이템 설정
        //replace(): 기존에 생성된 프래그먼트들을 모두 onDestroy상태로 만들고 새로운 프래그먼트 1개를 화면에 보여줌
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