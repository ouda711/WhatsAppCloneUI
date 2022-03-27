package com.example.whatsappclone.tabwithpageviewer.fragments;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.whatsappclone.ChatList;
import com.example.whatsappclone.CustomChatListAdapter;
import com.example.whatsappclone.MessageActivity;
import com.example.whatsappclone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList chatList = getChatData();
        View view  = inflater.inflate(R.layout.fragment_chat, container, false);
        final ListView lv = (ListView) view.findViewById(R.id.chat_list);
        lv.setAdapter(new CustomChatListAdapter(getActivity(), chatList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ChatList chatList1 = (ChatList) lv.getItemAtPosition(i);
                Toast.makeText(getContext(), "Selected :", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public ArrayList getChatData() {
        ArrayList<ChatList> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            results.add(new ChatList());
        }
        return results;
    }

//    private ArrayList getListData() {
//        ArrayList<ListItem> results = new ArrayList<>();
//        ListItem user1 = new ListItem();
//        user1.setName("Suresh Dasari");
//        user1.setDesignation("Team Leader");
//        user1.setLocation("Hyderabad");
//        results.add(user1);
//        ListItem user2 = new ListItem();
//        user2.setName("Rohini Alavala");
//        user2.setDesignation("Agricultural Officer");
//        user2.setLocation("Guntur");
//        results.add(user2);
//        ListItem user3 = new ListItem();
//        user3.setName("Trishika Dasari");
//        user3.setDesignation("Charted Accountant");
//        user3.setLocation("Guntur");
//        results.add(user3);
//        return results;
//    }
}