package com.example.version0;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.version0.databinding.FragmentGroupsBinding;

import java.util.ArrayList;
import java.util.List;


public class Groups extends Fragment {

    FragmentGroupsBinding binding;
    GroupAdapter groupAdapter;
    ArrayList<GroupData> dataArrayList = new ArrayList<>();
    GroupData groupData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGroupsBinding.inflate(inflater, container, false);
        return binding.getRoot();

        int[] studentsList = {};
        String[] nameList = {"1"};
        String[] numberList = {"2 students"};
        for (int i = 0; i < nameList.length; i++) {
            groupData = new GroupData(nameList[i], numberList[i], studentsList[i]);
            dataArrayList.add(groupData);

        }
        groupAdapter = new GroupAdapter(Groups.this, dataArrayList);
        binding.listView.setAdapter(groupAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailGroup.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("number", numberList[i]);
                intent.putExtra("students", studentsList[i]);
                startActivity(intent);
            }
        });
    }

}
//(R.layout.fragment_groups, container, false)