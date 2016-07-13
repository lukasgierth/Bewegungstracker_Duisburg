package org.hsbo.gierthhensen.bewegungstrackerduisburg;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * FragmentClass for the status/settings fragment.
 * It is possible to set the tracking rate here.
 */
public class StatusFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View view;
    public static final String UPDATE_INTERVAL = "updateInterval";

    /**
     * Required empty public constructor.
     */
    public StatusFragment() {
    }


    /**
     * Creates a new instance of StatusFragment.
     * @return frg
     */
    public static Fragment newInstance() {
        StatusFragment frg = new StatusFragment();
        return frg;
    }

    /**
     * Called when a fragment is created.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState==null){

        }
        else {

        }
    }

    /**
     * Called on first creation of the fragment.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_status, container, false);

        /*
        Spinner Element
        */
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_interval);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.interval_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return view;
    }


    /**
     * Called when connected activity is already present.
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
        }
    }

    /**
     * Checks state of saved instances of this fragment.
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * Called when an item from the spinner element gets selected.
     * @param parent
     * @param view
     * @param pos
     * @param id
     */
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        int a = parent.getSelectedItemPosition();
        int interval;

        if (a == 0){
            interval = 5;
        }
        else if (a == 1){
            interval = 10;
        }
        else if (a == 2){
            interval = 15;
        }
        else{
            interval = 5;
        }

        SharedPreferences sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(UPDATE_INTERVAL, interval);
        editor.commit();
        Toast.makeText(getActivity(), "GPS Interval:  "+interval, Toast.LENGTH_SHORT).show();
    }

    /**
     * Called when no element gets selected. Does nothing at this moment.
     * @param parent
     */
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
