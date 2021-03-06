package com.example.android.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button fightBtn;
    private Button webBtn;
    private Button strengthBtn;
    private  Button backstoryBtn;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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
        View view=inflater.inflate(R.layout.fragment_pick_power,container,false);

        turtleBtn=(Button)view.findViewById(R.id.turtlebtn);
        lightningBtn=(Button)view.findViewById(R.id.lightningbtn);
        fightBtn=(Button)view.findViewById(R.id.fightbtn);
        webBtn=(Button)view.findViewById(R.id.webbtn);
        strengthBtn=(Button)view.findViewById(R.id.stregthbtn);
        backstoryBtn=(Button)view.findViewById(R.id.backstorybtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        fightBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);

        /*
        backstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainActivity mainActivity=(MainActivity)getActivity(); //by this it will go & find the activity  hosting them
                mainActivity.loadBackStoryScreen();
            }
        });*/



        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128); //to let user know its disabled

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);
        fightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb,0,0,0);
        strengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength,0,0,0);



        Button btn=(Button)v; //casting v into a button..by this we can grab button out of this
        int  leftDrawable=0;
        if (btn==turtleBtn){
            leftDrawable=R.drawable.lightning;
        }else if(btn==lightningBtn){
            leftDrawable=R.drawable.atomic;
        } else if(btn==fightBtn){
            leftDrawable=R.drawable.rocket;
        }else if(btn==webBtn){
            leftDrawable=R.drawable.spiderweb;
        }else if(btn==strengthBtn){
            leftDrawable=R.drawable.superstrength;
        }

        //in this view we wanna set rhs to have the check button
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.itemselected,0);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerInteraction(Uri uri);
    }
}
