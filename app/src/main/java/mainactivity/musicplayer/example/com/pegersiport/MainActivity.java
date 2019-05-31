package mainactivity.musicplayer.example.com.pegersiport;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import mainactivity.musicplayer.example.com.pegersiport.fragmins.PegeFragment1;
import mainactivity.musicplayer.example.com.pegersiport.fragmins.PegeFragment2;
import mainactivity.musicplayer.example.com.pegersiport.fragmins.PegeFragment3;

public class MainActivity extends AppCompatActivity {

    private VertivalViewPeger vertivalViewPeger;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> list = new ArrayList<>();
        list.add(new PegeFragment1());
        list.add(new PegeFragment2());
        list.add(new PegeFragment3());

        vertivalViewPeger = findViewById(R.id.pager);
        pagerAdapter = new VPegerAdaptor(getSupportFragmentManager(),list);

        vertivalViewPeger.setAdapter(pagerAdapter);
    }
}
