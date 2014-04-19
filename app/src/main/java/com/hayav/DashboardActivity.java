package com.hayav;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

import java.util.ArrayList;

public class DashboardActivity extends Activity {

    ArrayList<Item> gridArray = new ArrayList<Item>();
    DashboardGridViewAdapter dashboardGridViewAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        GridView gridView = (GridView) findViewById(R.id.GridView);

        gridArray.add(new Item("Person1","3 NIS"));
        gridArray.add(new Item("Person2","Harry Potter Book"));
        gridArray.add(new Item("Person3","5 NIS"));
        gridArray.add(new Item("Person4","15 NIS"));
        gridArray.add(new Item("Person5","5 NIS"));
        gridArray.add(new Item("Person6","10 NIS"));

        dashboardGridViewAdapter = new DashboardGridViewAdapter(this, R.layout.dashboard_row_grid, gridArray);
        gridView.setAdapter(dashboardGridViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}