package com.nackademin.foureverhh.recyclerviewwithtableviewonfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {

    View view;

    private RecyclerView myRecyclerview;
    private List<Contact> contactList;


    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contact_fragment,container,false);
        myRecyclerview = view.findViewById(R.id.recyclerView_contact);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), contactList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        myRecyclerview.setAdapter(recyclerViewAdapter);
        myRecyclerview.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();
        contactList.add(new Contact("Jack1","100",R.drawable.jack1));
        contactList.add(new Contact("Jack2","200",R.drawable.jack2));
        contactList.add(new Contact("Jack3","300",R.drawable.jack3));
        contactList.add(new Contact("Jack4","400",R.drawable.jack4));
        contactList.add(new Contact("Jack5","500",R.drawable.jack5));
        contactList.add(new Contact("Jack6","600",R.drawable.jack6));
        contactList.add(new Contact("Jack7","700",R.drawable.jack7));
        contactList.add(new Contact("Jack8","800",R.drawable.jack8));
    }
}
