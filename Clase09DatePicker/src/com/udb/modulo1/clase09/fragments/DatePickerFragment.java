package com.udb.modulo1.clase09.fragments;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
	
	private DatePickedListener mListener;
	
	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        
        mListener.onDatePicked(c);
	}
	
	@Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try{
            mListener = (DatePickedListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " debe implementar" + DatePickedListener.class.getName());
        }
    }
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
	
	public interface DatePickedListener{
	    public void onDatePicked(Calendar date);
	}


}
