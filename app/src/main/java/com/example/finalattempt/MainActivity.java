package com.example.finalattempt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.finalattempt.Adapter.CategoryAdapter;
import com.example.finalattempt.Adapter.PopularAdapter;
import com.example.finalattempt.Domain.CategoryDomain;
import com.example.finalattempt.Domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularlist=findViewById(R.id.recyclerView2);
        recyclerViewPopularlist.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain>foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","pizza","Pepperoni slice, mozzerella cheese,fresh oregano, ground peppers", 600.00));
        foodList.add(new FoodDomain("Beef Burger","burger","Ground Beef, american cheese,fresh lettuce and tomatoes", 400.00));
        foodList.add(new FoodDomain("Vegetable Pizza","pizza2","Olives,virgin olive oil, mozzerella cheese,fresh oregano, ground peppers", 500.00));


        adapter2= new PopularAdapter(foodList);
        recyclerViewPopularlist.setAdapter(adapter2);
    }

}