/*
 * *
 *  * Copyright (C) 2017 Ryan Kay Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wiseassblog.androidresttutorial.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wiseassblog.androidresttutorial.R;
import com.wiseassblog.androidresttutorial.data.GithubRepository;
import com.wiseassblog.androidresttutorial.logic.Controller;

import java.util.List;

/**
 * For simplicities' sake, this Activity functions as the View. I'd normally have a Fragment
 * function as the View instead; with the Activity acting as container.
 */
public class ListActivity extends AppCompatActivity implements ViewInterface, View.OnClickListener {

    private List<GithubRepository> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Toolbar toolbar;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        toolbar = (Toolbar) findViewById(R.id.tlb_list_activity);
        toolbar.setTitle(R.string.title_toolbar);
        toolbar.setLogo(R.drawable.ic_view_list_white_24dp);
        toolbar.setTitleMarginStart(72);

        FloatingActionButton fabulous = (FloatingActionButton) findViewById(R.id.fab_create_new_item);

        fabulous.setOnClickListener(this);

        //TODO create via D.I.
        //controller = new Controller(this, );
    }

    @Override
    public void startMainActivity() {
        startActivity(new Intent(this, ListActivity.class));
    }

    @Override
    public void setUpAdapterAndView(List<GithubRepository> listOfData) {
        this.listOfData = listOfData;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                layoutManager.getOrientation()
        );

        itemDecoration.setDrawable(
                ContextCompat.getDrawable(
                        ListActivity.this,
                        R.drawable.divider_white
                )
        );

        recyclerView.addItemDecoration(
                itemDecoration
        );
    }

    @Override
    public void onClick(View v) {

    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        @Override
        public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }


        @Override
        public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
            GithubRepository repo = listOfData.get(position);

            Glide.with(ListActivity.this)
                    .load(repo.getAvatar_url())
                    .into(holder.userAvatar);

            holder.description.setText(
                    repo.getDescription()
            );

            holder.creationDate.setText(
                    repo.getCreated_at()
            );
        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }


        class CustomViewHolder extends RecyclerView.ViewHolder {

            private ImageView userAvatar;
            private TextView creationDate;
            private TextView description;

            public CustomViewHolder(View itemView) {
                super(itemView);
                this.userAvatar = (ImageView) itemView.findViewById(R.id.imv_list_item_circle);
                this.creationDate = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.description = (TextView) itemView.findViewById(R.id.lbl_message);
            }
        }
    }
}
