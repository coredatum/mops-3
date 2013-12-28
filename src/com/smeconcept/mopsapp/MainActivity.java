package com.smeconcept.mopsapp;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TimePicker;
import java.util.*;
import android.database.sqlite.*;

import android.net.Uri;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.util.ArrayList;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import java.text.*;

public class MainActivity extends Activity {
    Spinner s1,s2,s3;
    String tm_n1,tm_n2, tm_n3, tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10;
String[] presidents11 = {
		tm_n1, 
		tm_n3, 
		tm_n3, tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10
		  };

	

    String tm1, tm2, tm3, tm4;
	Spinner status1, status2, status_on_1;
    String[] status = {
     "opening",
	 "cleaning", 
	 "training",
	 "cust serv",
	 "cash",
	 "meeting"
    };

	Spinner h1,h2,h3,h4,l1,l2,rt, h_on_1, h_on_2, l_on_1;
	String[] tm = {
		"1","2","3"
	};
	Integer [] hours = {
		0,
		5,
		6,
		7,
		8,
		9,
		10,
		11,
		12,
		13,
		14,
		15,
		16,
		17,
		18,
		19,
		20,
		21,
		22,
		23
	}; 
    Integer day_picker1;
	Integer c_int;
	Integer c_int_c;
	Integer test;
	Spinner day_picker;
	Integer [] day = {
		1,2,3,4,
		5,
		6,
		7,
		8,
		9,
		10,
		11,
		12,
		13,
		14,
		15,
		16,
		17,
		18,
		19,
		20,
		21,
		22,
		23,24, 25,26,27,28,29,30,31
	}; 
	Integer month_picker1;
	Spinner month_picker;
	Integer test_db;
	Integer [] month = {
		1,2,3,4,
		5,
		6,
		7,
		8,
		9,
		10,
		11,
		12};
	Integer year_picker1;
	Spinner year_picker;
		Integer [] year = {
		2013, 2014, 2015, 2016, 2017};
	String tm_nn1, tm_nn2, tm_nn3, tm_nn4, tm_nn5, tm_nn6, tm_nn7, tm_nn8, tm_nn9, tm_nn10;
	String[] presidents2 = {
		tm_nn1, tm_nn2, tm_nn3, tm_nn4, tm_nn5, tm_nn6, tm_nn7, tm_nn8, tm_nn9, tm_nn10

	};	
	String[] status_11 = {
		"opening",
		"cleaning", 
		"training",
		"cust serv",
		"cash",
		"meeting"
	};
	
	String [] presidents;
	Integer nn, index, index2, index_m, index_d, index_y;
    String ava_fr_1;
	String ava_to_1;
	Cursor cnew1;
	String ava_to_on_1, ava_fr_on_1;
	String status_1, status_2, status_on_tm_1;
	Integer hhh1, hhh2, lll1;
	Integer hhh3, hhh4, lll2;
	String presidents1, presidents22, presidents111, presidents_on_11;
	EditText amount1;
	EditText amount2;
	EditText amount3;
	EditText amount4;
	EditText amount5;
	EditText address_nnn;
	EditText sales;
	EditText tm_1, tm_2;
	TextView tt;
	TextView ty;
	TextView db_record_check;
	TextView Cur_T;
	Button calculate;
	String calculator;
	Button edit1;
	Button time_picker;
	double x;
	double y;
	double a;
	double b;
	// totsl spent time
	double d;
	// Efficiency
	int rw;
	double z;
	double w;
	double e;
	//shifts <from>, <to>;
	double hh1;
	double hh2;
	Integer hh3;
	Integer ooo, ppp, nnn;
	Integer row_N1, row_N2, row_N3;
	Integer hh4;
	Button update;
	Integer hh_on_1, hh_on_2;
	//lunches
	double ll1;
	Integer ll2;
	Integer ll_on_1;
	//report time
	double rtt;
	double hh2_1;
	double hh4_3;
	Integer index_on_1;

	DBAdapter db;
	DBContacts DBC2;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
		
		
		db = new DBAdapter(this);
		DBC2= new DBContacts(this);
				
        DBC2.open();
			
/*       if (DBC2.insertContact("first contact", 6,10, 14, "openning",1,1,2013, 0,0,999,"info") >= 0){
			Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();}
		

			if (DBC2.insertContact("Smith S.", 6,10, 14, "openning",1,1,2013, 0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (DBC2.insertContact("Kristal", 8,12, 16, "GR", 1,1,2013,0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}

			if (DBC2.insertContact("John", 6,10, 14, "openning",1,1,2013, 0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (DBC2.insertContact("Bond", 8,12, 16, "GR", 1,1,2013,0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}

			if (DBC2.insertContact("Poll", 6,10, 14, "openning",1,1,2013, 0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (DBC2.insertContact("Brenda", 8,12, 16, "GR", 1,1,2013,0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}

			if (DBC2.insertContact("Adele", 6,10, 14, "openning",1,1,2013, 0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (DBC2.insertContact("Kristina", 8,12, 16, "GR", 1,1,2013,0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}

			if (DBC2.insertContact("Mackle", 6,10, 14, "openning",1,1,2013, 0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (DBC2.insertContact("Pitter", 8,12, 16, "GR", 1,1,2013,0,0,999,"info") >= 0){
				//Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();			
		    }
			
	   DBC2.close();
		
	  
	/*  { DBC2.open();
		
	cnew1 = DBC2.getAllContacts();
		
	if (cnew1.moveToFirst())
	   
	   {			
	
	do {		
		    String test1=cnew1.getString(0);
		    String test2=cnew1.getString(11);
						
	    	c_int_c=Integer.parseInt(test1.toString());
			c_int=Integer.parseInt(test2.toString());
		   
		 	Toast.makeText(getBaseContext(), "contacts:"+c_int_c, Toast.LENGTH_SHORT).show();		
			test=999-c_int;
	
			//  DisplayContact(c);	

     if (test==0){
		
//	if (c_int_c==1){
     DBC2.deleteContact(c_int_c);
	 Toast.makeText(getBaseContext(), "DB does not exist. Creating new DB", Toast.LENGTH_SHORT).show();		
			
	/*  if (DBC2.insertContact("Smith S.", 6,10, 14, "openning",1,1,2013, 0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        } 
		
		
        if (DBC2.insertContact("Kristal", 8,12, 16, "GR", 1,1,2013,0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();			
        }
		
		if (DBC2.insertContact("John", 6,10, 14, "openning",1,1,2013, 0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }


        if (DBC2.insertContact("Bond", 8,12, 16, "GR", 1,1,2013,0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }
		
		if (DBC2.insertContact("Poll", 6,10, 14, "openning",1,1,2013, 0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }


        if (DBC2.insertContact("Brenda", 8,12, 16, "GR", 1,1,2013,0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }
		
		if (DBC2.insertContact("Adele", 6,10, 14, "openning",1,1,2013, 0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }


        if (DBC2.insertContact("Kristina", 8,12, 16, "GR", 1,1,2013,0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }
		
		if (DBC2.insertContact("Mackle", 6,10, 14, "openning",1,1,2013, 0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
        }


        if (DBC2.insertContact("Pitter", 8,12, 16, "GR", 1,1,2013,0,0,0,"info") >= 0){
            Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();        
		} 
*/
		/*}
		
		else{

			Toast.makeText(getBaseContext(), "DBC does exist. ", Toast.LENGTH_SHORT).show();		
			// DBC2.deleteContact(c_int_c);
		}
		
	//	} 

		} while (cnew1.moveToNext());
	
		}
		
		DBC2.close();}
		
		*/
		
		
		
	   db.open();

		if (db.insertContact("Smith", "6473456789","smith@gmail.com","10", "14",111)  >= 0){
			Toast.makeText(this, "New DB has been created", Toast.LENGTH_LONG).show();
			}

		if (db.insertContact("Kristal", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "New DB has been created", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Bond", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("John", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Kristina", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Mackle", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Pitter", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Adele", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Brenda", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}


			if (db.insertContact("Poll", "6473456789","smith@gmail.com","10", "14",111) >= 0){
				Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
			}
			
		
		db.close();
	

	db.open();

		Cursor cdb1 = db.getAllContacts();

		if (cdb1.moveToFirst())

	do {

	String test1=cdb1.getString(6);
	String test2=cdb1.getString(0);


	Integer c_db=Integer.parseInt(test1.toString());
	Integer c_db_c=Integer.parseInt(test2.toString());
	Toast.makeText(getBaseContext(), "contacts:"+c_db_c, Toast.LENGTH_SHORT).show();		
	test_db=111-c_db;
	//  DisplayContact(c);


	if ((test_db==0)&&(c_db_c<11)){
		
   // db.updateContact(c_db_c);
	Toast.makeText(getBaseContext(), "DB does not exist. Creating new DB. Update Contr for contact:" + c_db_c, Toast.LENGTH_SHORT).show();		
				
	
   {  if (db.updateDBControl(c_db_c, 0)){
            Toast.makeText(this, "DB Control update successful."+c_db_c, Toast.LENGTH_LONG).show();
            }
	  else {
		Toast.makeText(getBaseContext(), "Could not update DBControl ", Toast.LENGTH_SHORT).show();		
		     }
	
      }}
	  
		if ((test_db==0)&&(c_db_c>10)){
		
			Toast.makeText(getBaseContext(), "DB exists. The following contact will be deleted. "+ c_db_c, Toast.LENGTH_SHORT).show();		
			db.deleteContact(c_db_c);
		 }
	  
	    else {
			Toast.makeText(getBaseContext(), "DB exists. New created contacts will be deleted. ", Toast.LENGTH_SHORT).show();		
		}
	  
	  
	
	  
	  
		} while (cdb1.moveToNext());
		
		db.close();
		
		

	
		
		
		edit1=(Button)findViewById(R.id.edit1);
		edit1.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent i=new Intent(MainActivity.this,EditContactMenu.class);
					startActivity(i);
					finish();
				}
			});
			

		Button tracking=(Button)findViewById(R.id.tracking);
		tracking.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent ii=new Intent(MainActivity.this,Tracking_Tool.class);
					startActivity(ii);
					finish();
				}
			});
		
		{
		
		
        //---Spinner View---
		
	 /*   db.open();
		Cursor c1 = db.getContact(1);
		Cursor c2 = db.getContact(2);

		//read database	
		if (c1 !=null){
			c1.moveToFirst();   	
			String tm1=c1.getString(0);
			String tm2=c2.getString(0);
			String [] tm={
				tm1,tm2
			};	
			
			Spinner tm_1 = (Spinner) findViewById(R.id.tm_1);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, tm);
			tm_1.setAdapter(adapter);
			int index1 = tm_1.getSelectedItemPosition();
			String tmm_1=tm[index1];
		}*/
	 
		
		//read database	
		db.open();
		Cursor c = db.getContact(1);				
		if (c !=null)
		 tm_n1=c.getString(1);
		 
		 
		Cursor c1 = db.getContact(2);		
		if (c1 !=null)
		 tm_n2=c1.getString(1);		 
		 
		 
		Cursor c2 = db.getContact(3);		
		 if (c2!=null)
			tm_n3=c2.getString(1);
			 		 
		Cursor c3 = db.getContact(4);		
		if (c3!=null)
			tm_n4=c3.getString(1);
					
		Cursor c4 = db.getContact(5);		
		if (c4!=null)
			tm_n5=c4.getString(1);
			
		Cursor c5 = db.getContact(6);		
		if (c5!=null)
			tm_n6=c5.getString(1);
			
		Cursor c6 = db.getContact(7);		
		if (c6!=null)
			tm_n7=c6.getString(1);

		Cursor c7 = db.getContact(8);		
		if (c7!=null)
			tm_n8=c7.getString(1);

		Cursor c8 = db.getContact(9);		
		if (c8!=null)
			tm_n9=c8.getString(1);

		Cursor c9 = db.getContact(10);		
		if (c9!=null)
			tm_n10=c9.getString(1); 
		
		String[] presidents = {"choose",
			tm_n1, tm_n2, tm_n3
			, tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10
		
    };	 
		 db.close();		
		
        s1 = (Spinner) findViewById(R.id.spinner1);
		
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, presidents);
        s1.setAdapter(adapter);
        
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
					index = s1.getSelectedItemPosition();
				
		

					String[] presidents = {"choose",
						tm_n1, tm_n2, tm_n3, tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10

					};	 
					 presidents1=presidents [index];
					 
					Toast.makeText(getBaseContext(),
								   "You have selected TM : " + presidents1, 
								   Toast.LENGTH_SHORT).show(); 
					
					nn=index+1; 

					db.open();
			//intent to transfer data to other actovity
			
			    	Cursor c = db.getContact(nn);
					
					//read database	
					if (c !=null){
						c.moveToFirst();   

						String string1=c.getString(0);
						TextView tm_1=(TextView)findViewById(R.id.tm_1);
						tm_1.setText(string1);
						
						String string2=c.getString(4);
						ava_fr_1=string2;
						 EditText availab_fr_1=(EditText)findViewById(R.id.availab_fr_1);
						 availab_fr_1.setText(string2);
						 
						String string22=c.getString(5);
						ava_to_1=string22;
						EditText availab_to_1=(EditText)findViewById(R.id.availab_to_1);
						availab_to_1.setText(string22);
						
						
						
					/*	 String string3=c.getString(2);
						 EditText address_nnn=(EditText)findViewById(R.id.address_nnn);
						 address_nnn.setText(string3);
*/
                     db.close();
					 				 
					}
					/*getIntent().getStringExtra("tm_nn1");
					getIntent().getStringExtra("tm_nn2");
					getIntent().getStringExtra("tm_nn3");*/
					db.open();
					Cursor cc = db.getContact(1);				
					if (cc !=null)
						tm_n1=cc.getString(1);


					Cursor cc1 = db.getContact(2);		
					if (cc1 !=null)
						tm_n2=cc1.getString(1);		 


					Cursor cc2 = db.getContact(3);		
					if (cc2!=null)
						tm_n3=cc2.getString(1);

					Cursor cc3 = db.getContact(4);		
					if (cc3!=null)
						tm_n4=cc3.getString(1);
					
					Cursor cc4 = db.getContact(5);				
					if (cc4 !=null)
						tm_n5=cc4.getString(1);


					Cursor cc5 = db.getContact(6);		
					if (cc5 !=null)
						tm_n6=cc5.getString(1);		 


					Cursor cc6 = db.getContact(7);		
					if (cc6!=null)
						tm_n7=cc6.getString(1);

					Cursor cc7 = db.getContact(8);		
					if (cc7!=null)
						tm_n8=cc7.getString(1);
					

					Cursor cc8 = db.getContact(9);		
					if (cc8!=null)
						tm_n9=cc8.getString(1);

					Cursor cc9 = db.getContact(10);		
					if (cc9!=null)
						tm_n10=cc9.getString(1);
						
					
					if(index==1){tm_n1="";}
					else
					if (index==2){tm_n2="";}
					else
					if (index==3){tm_n3="";}
					else
					if (index==4){tm_n4="";}
					else
					if (index==5){tm_n5="";}
					else
					if (index==6){tm_n6="";}
					else
					if (index==7){tm_n7="";}
					else
					if (index==8){tm_n8="";}
					else
					if (index==9){tm_n9="";}
					else
					if (index==10){tm_n10="";}

					String[] presidents2 = {"choose",
						tm_n1, tm_n2, tm_n3
						,tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10
					};	
					  
					s2 = (Spinner) findViewById(R.id.spinner2);
					ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
						getBaseContext(), android.R.layout.simple_spinner_item, presidents2);
					s2.setAdapter(adapter1);

					s2.setOnItemSelectedListener(new OnItemSelectedListener() {
							public void onItemSelected(AdapterView<?> arg0, View arg1, 
													   int arg2, long arg3) {
								index2 = s2.getSelectedItemPosition(); 
								

								String[] presidents = {"choose",
									tm_n1, tm_n2, tm_n3, tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10

								};	 
								presidents22=presidents[index2];
								Toast.makeText(getBaseContext(),
											   "You have selected TM2 " + presidents22, 
											   Toast.LENGTH_SHORT).show();

								Integer nn1=index2+1;
								db.open();
								Cursor ccccc1= db.getContact(nn1);

								//read database	
								if (ccccc1!=null){
									ccccc1.moveToFirst();   

									String string1=ccccc1.getString(0);
									TextView tm_2=(TextView)findViewById(R.id.tm_2);
									tm_2.setText(string1);

									String string2=ccccc1.getString(4);
									ava_fr_1=string2;
									EditText availab_fr_2=(EditText)findViewById(R.id.availab_fr_2);
									availab_fr_2.setText(string2);

									String string22=ccccc1.getString(5);
									ava_to_1=string22;
									EditText availab_to_2=(EditText)findViewById(R.id.availab_to_2);
									availab_to_2.setText(string22);

								}
								
								db.open();
					Cursor cccc = db.getContact(1);				
					if (cccc !=null)
						tm_n1=cccc.getString(1);


					Cursor cccc1 = db.getContact(2);		
					if (cccc1 !=null)
						tm_n2=cccc1.getString(1);		 


					Cursor cccc2 = db.getContact(3);		
					if (cccc2!=null)
						tm_n3=cccc2.getString(1);

					Cursor cccc3 = db.getContact(4);		
					if (cccc3!=null)
						tm_n4=cccc3.getString(1);
					
					Cursor cccc4 = db.getContact(5);				
					if (cccc4 !=null)
						tm_n5=cccc4.getString(1);


					Cursor cccc5 = db.getContact(6);		
					if (cccc5 !=null)
						tm_n6=cccc5.getString(1);		 


					Cursor cccc6 = db.getContact(7);		
					if (cccc6!=null)
						tm_n7=cccc6.getString(1);

					Cursor cccc7 = db.getContact(8);		
					if (cccc7!=null)
						tm_n8=cccc7.getString(1);
					

					Cursor cccc8 = db.getContact(9);		
					if (cccc8!=null)
						tm_n9=cccc8.getString(1);

					Cursor cccc9 = db.getContact(10);		
					if (cccc9!=null)
						tm_n10=cccc9.getString(1);
						
					
					if(index==1){tm_n1="";}
					else
					if (index==2){tm_n2="";}
					else
					if (index==3){tm_n3="";}
					else
					if (index==4){tm_n4="";}
					else
					if (index==5){tm_n5="";}
					else
					if (index==6){tm_n6="";}
					else
					if (index==7){tm_n7="";}
					else
					if (index==8){tm_n8="";}
					else
					if (index==9){tm_n9="";}
					else
					if (index==10){tm_n10="";}
					
								if(index2==1){tm_n1="";}
								else
								if (index2==2){tm_n2="";}
								else
								if (index2==3){tm_n3="";}
								else
								if (index2==4){tm_n4="";}
								else
								if (index2==5){tm_n5="";}
								else
								if (index2==6){tm_n6="";}
								else
								if (index2==7){tm_n7="";}
								else
								if (index2==8){tm_n8="";}
								else
								if (index2==9){tm_n9="";}
								else
								if (index2==10){tm_n10="";}

					String[] presidents_on_1 = {"choose",
						tm_n1, tm_n2, tm_n3
						,tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10
					};	
					  
					s3 = (Spinner) findViewById(R.id.spinner_on_1);
					ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
						getBaseContext(), android.R.layout.simple_spinner_item, presidents_on_1);
					s3.setAdapter(adapter1);

					s3.setOnItemSelectedListener(new OnItemSelectedListener() {
							public void onItemSelected(AdapterView<?> arg0, View arg1, 
													   int arg2, long arg3) {
								int index_on_1 = s3.getSelectedItemPosition(); 
								

								String[] presidents = {"choose",
									tm_n1, tm_n2, tm_n3, tm_n4, tm_n5, tm_n6, tm_n7, tm_n8, tm_n9, tm_n10

								};	 
								presidents_on_11=presidents[index_on_1];
								Toast.makeText(getBaseContext(),
											   "You have selected TM oncall" + presidents_on_11, 
											   Toast.LENGTH_SHORT).show();

								Integer nn_on1=index_on_1+1;
								db.open();
								Cursor c_1= db.getContact(nn_on1);

								//read database	
								if (c_1!=null){
									c_1.moveToFirst();   

									/*String string1=c1.getString(0);
									TextView tm_2=(TextView)findViewById(R.id.tm_2);
									tm_2.setText(string1);*/

									String string_2=c_1.getString(4);
									ava_fr_on_1=string_2;
									EditText availab_on_fr_1=(EditText)findViewById(R.id.availab_on_fr_1);
									availab_on_fr_1.setText(string_2);

									String string_22=c_1.getString(5);
									ava_to_on_1=string_22;
									EditText availab_on_to_1=(EditText)findViewById(R.id.availab_on_to_1);
									availab_on_to_1.setText(string_22);

								}
								
							}
							public void onNothingSelected(AdapterView<?> arg0) {
							} 
						});
					

							}
							public void onNothingSelected(AdapterView<?> arg0) {
							} 
						});
					
				}


				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});
		/*s3 = (Spinner) findViewById(R.id.spinner_on_1);
		
        ArrayAdapter<String> adapter_on_1 = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, presidents);
        s3.setAdapter(adapter_on_1);
        
        s3.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
					index_on_1 = s3.getSelectedItemPosition();
					
		
	
					 presidents1=presidents11 [index];}
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});*/
			
	/*
		db.open();
		Cursor cc = db.getContact(1);				
		if (cc !=null)
			tm_nn1=cc.getString(1);
			
		Cursor cc1 = db.getContact(2);		
		if (cc1 !=null)
			tm_nn2=cc1.getString(1);	

		Cursor cc2 = db.getContact(3);		
		if (cc2!=null)
			tm_nn3=cc2.getString(1);

		Cursor cc3 = db.getContact(4);		
		if (cc3!=null)
			tm_nn4=cc3.getString(1);

		Cursor cc4 = db.getContact(5);		
		if (cc4!=null)
			tm_nn5=cc4.getString(1);

		Cursor cc5 = db.getContact(6);		
		if (cc5!=null)
			tm_nn6=cc5.getString(1);

		Cursor cc6 = db.getContact(7);		
		if (cc6!=null)
			tm_nn7=cc6.getString(1);

		Cursor cc7 = db.getContact(8);		
		if (c7!=null)
			tm_nn8=cc7.getString(1);

		Cursor cc8 = db.getContact(9);		
		if (c8!=null)
			tm_nn9=cc8.getString(1);

		Cursor cc9 = db.getContact(10);		
		if (c9!=null)
			tm_nn10=cc9.getString(1);
		


		db.close(); */
		
		/*if (getIntent().getIntExtra("index",0)==0){
			tm_nn1="";}
		if (getIntent().getIntExtra("index",0)==1){
				tm_nn2="";}
		if (getIntent().getIntExtra("index",0)==2){
				tm_nn3="";}*/
			
			
			String[] status = {
				"opening",
				"cleaning", 
				"training",
				"cust serv",
				"cash",
				"meeting"
			};
			 
				status1 = (Spinner) findViewById(R.id.status1);
				ArrayAdapter<String> adapter_st = new ArrayAdapter<String>(
					this, android.R.layout.simple_spinner_item, status);
				status1.setAdapter(adapter_st);
				
			status1.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, 
											   int arg2, long arg3) {
						int index_stat = status1.getSelectedItemPosition(); 

						status_1=status_11[index_stat];

					}
					public void onNothingSelected(AdapterView<?> arg0) {
					} 
				});
		
			
			status2 = (Spinner) findViewById(R.id.status2);
			ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, status);
			status2.setAdapter(adapter11); 
			
			status2.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, 
											   int arg2, long arg3) {
						int index_2 = status2.getSelectedItemPosition(); 

						status_2=status_11[index_2];

					}
					public void onNothingSelected(AdapterView<?> arg0) {
					} 
				});
		

		h1 = (Spinner) findViewById(R.id.hours1);
		ArrayAdapter<Integer> adapter3 = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, hours);
		h1.setAdapter(adapter3);
			
		h1.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
				hh1 = h1.getSelectedItemPosition(); 
				
					/*
					TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
					timePicker.setIs24HourView(true);
					timePicker.setVisibility(View.VISIBLE);
					timePicker.setOnClickListener(new Button.OnClickListener() { 
					public void onClick	(View v) {
					TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
					timePicker.setIs24HourView(true);
					
					hhh1=timePicker.getCurrentHour();
					
					timePicker.setVisibility(View.INVISIBLE);
					

							}});
							
							*/
					
	    	int index3=h1.getSelectedItemPosition();
     		hhh1=hours[index3];
//	    	hhh1=hours[3];
				
					Toast.makeText(getBaseContext(),
								   "You have selected hours " + hhh1, 
								   Toast.LENGTH_SHORT).show();
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});

		h2 = (Spinner) findViewById(R.id.hours2);

		ArrayAdapter<Integer> adapter4 = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, hours);
		h2.setAdapter(adapter4);

		h2.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
//					int index = h2.getSelectedItemPosition(); 
					hh2 = h2.getSelectedItemPosition();
				
				    int index5=h2.getSelectedItemPosition();
					hhh2=hours[index5];
				//	hhh2=hours[7];
					
					Toast.makeText(getBaseContext(),
								   "You have selected hours " + hhh2, 
								   Toast.LENGTH_SHORT).show();
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});

		l1 = (Spinner) findViewById(R.id.lunch1);

		ArrayAdapter<Integer> adapter7 = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, hours);
		l1.setAdapter(adapter7);

		l1.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
//					int index = h2.getSelectedItemPosition(); 
					ll1 = l1.getSelectedItemPosition(); 
					int index6=l1.getSelectedItemPosition();			
				    lll1=hours[index6];
//					lll1=hours[4];
								Toast.makeText(getBaseContext(),
					 "You have selected hours " + lll1, 
					 Toast.LENGTH_SHORT).show(); 

					if ((hh1>ll1)||(hh2<ll1))

						Toast.makeText(getBaseContext(),
									   "You have selected wrong lunch ", 
									   Toast.LENGTH_SHORT).show();}

				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});
			
			//choose the Day
			day_picker = (Spinner) findViewById(R.id.day_picker);
			ArrayAdapter<Integer> adapter_day = new ArrayAdapter<Integer>(
				this, android.R.layout.simple_spinner_item, day);
			day_picker.setAdapter(adapter_day);
			
			day_picker.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, 
											   int arg2, long arg3) {
			index_d= day_picker.getSelectedItemPosition();
			day_picker1=day[index_d];
			
     		Toast.makeText(getBaseContext(),
						   "You have selected hours " + day_picker1, 
						   Toast.LENGTH_SHORT).show();}
						   
					public void onNothingSelected(AdapterView<?> arg0) {
					} 
			});
			
			//choose the Month
			month_picker = (Spinner) findViewById(R.id.month_picker);
			ArrayAdapter<Integer> adapter_month = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, month);
			month_picker.setAdapter(adapter_month);
			
			month_picker.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, 
											   int arg2, long arg3) {
			index_m= month_picker.getSelectedItemPosition();
			month_picker1=month[index_m];}
			
					public void onNothingSelected(AdapterView<?> arg0) {
					} 
				});
			
			//choose the year
			year_picker = (Spinner) findViewById(R.id.year_picker);
			ArrayAdapter<Integer> year_adapter = new ArrayAdapter<Integer>(
				this, android.R.layout.simple_spinner_item, year);
			year_picker.setAdapter(year_adapter);
			
			year_picker.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, 
											   int arg2, long arg3) {
			index_y= year_picker.getSelectedItemPosition();
			year_picker1=year[index_y];}
			
	public void onNothingSelected(AdapterView<?> arg0) {
	} 
	});

		
			
			
		h3 = (Spinner) findViewById(R.id.hours3);

		ArrayAdapter<Integer> adapter5 = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, hours);
		h3.setAdapter(adapter5);

		h3.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
    				int index_h3 = h3.getSelectedItemPosition(); 
					hh3 = h3.getSelectedItemPosition(); 	
					hhh3=hours[index_h3];
					Toast.makeText(getBaseContext(),
								   "You have selected hours " + hhh3, 
								   Toast.LENGTH_SHORT).show();
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});
		h4 = (Spinner) findViewById(R.id.hours4);

		ArrayAdapter<Integer> adapter6 = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, hours);
		h4.setAdapter(adapter6);

		h4.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
  				int index_h4 = h4.getSelectedItemPosition(); 
					hh4 = h4.getSelectedItemPosition(); 	
					hhh4=hours[index_h4];
					Toast.makeText(getBaseContext(),
								   "You have selected hours " + hhh4, 
								   Toast.LENGTH_SHORT).show();
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});	

		// lunch_2
		l2 = (Spinner) findViewById(R.id.lunch2);

		ArrayAdapter<Integer> adapter8 = new ArrayAdapter<Integer>(
			this, android.R.layout.simple_spinner_item, hours);
		l2.setAdapter(adapter8);

		l2.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
    				int index_l2 = l2.getSelectedItemPosition(); 
					ll2 = l2.getSelectedItemPosition(); 	
					lll2=hours[index_l2];
							Toast.makeText(getBaseContext(),
					 "You have selected hours " + lll2, 
					 Toast.LENGTH_SHORT).show();  

					if ((hh3>ll2)||(hh4<ll2))
					{
						Toast.makeText(getBaseContext(),
									   "You have selected wrong lunch ", 
									   Toast.LENGTH_SHORT).show();}
				

						if ((hh3>ll2)||(hh4<ll2))
						{
							Toast.makeText(getBaseContext(),
										   "You have selected wrong lunch ", 
										   Toast.LENGTH_SHORT).show();}
					}
					public void onNothingSelected(AdapterView<?> arg0) {
					} 
				});
				
	
			status_on_1 = (Spinner) findViewById(R.id.status_on_1);
			ArrayAdapter<String> adapter111 = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, status);
			status_on_1.setAdapter(adapter111);
			
			status_on_1.setOnItemSelectedListener(new OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> arg0, View arg1, 
											   int arg2, long arg3) {
						int index_stat = status_on_1.getSelectedItemPosition(); 
						 	
						status_on_tm_1=status_11[index_stat];
		
		}
	public void onNothingSelected(AdapterView<?> arg0) {
	} 
	});

	h_on_1 = (Spinner) findViewById(R.id.hours_on_1_fr);

	ArrayAdapter<Integer> adapter_on1 = new ArrayAdapter<Integer>(
		this, android.R.layout.simple_spinner_item, hours);
	h_on_1.setAdapter(adapter_on1);

	h_on_1.setOnItemSelectedListener(new OnItemSelectedListener() {
	public void onItemSelected(AdapterView<?> arg0, View arg1, 
							   int arg2, long arg3) {
//					int index = h2.getSelectedItemPosition(); 
		Integer index_hh_on_1 = h_on_1.getSelectedItemPosition(); 	
		hh_on_1=hours[index_hh_on_1];
		Toast.makeText(getBaseContext(),
					   "You have selected hours " + hh_on_1, 
					   Toast.LENGTH_SHORT).show();
	}
	public void onNothingSelected(AdapterView<?> arg0) {
	} 
	});
	h_on_2 = (Spinner) findViewById(R.id.hours_on_1_to);

	ArrayAdapter<Integer> adapter_on2 = new ArrayAdapter<Integer>(
		this, android.R.layout.simple_spinner_item, hours);
	h_on_2.setAdapter(adapter_on2);

	h_on_2.setOnItemSelectedListener(new OnItemSelectedListener() {
	public void onItemSelected(AdapterView<?> arg0, View arg1, 
							   int arg2, long arg3) {
//					int index = h2.getSelectedItemPosition(); 
		Integer index_hh_on_2= h_on_2.getSelectedItemPosition(); 	
		hh_on_2=hours[index_hh_on_2];
		Toast.makeText(getBaseContext(),
					   "You have selected hours " + hh_on_2, 
					   Toast.LENGTH_SHORT).show();
	}
	public void onNothingSelected(AdapterView<?> arg0) {
	} 
	});	

	// lunch_2
	l_on_1 = (Spinner) findViewById(R.id.lunch_on_1);

	ArrayAdapter<Integer> adapter_on_l1 = new ArrayAdapter<Integer>(
		this, android.R.layout.simple_spinner_item, hours);
	l_on_1.setAdapter(adapter_on_l1);

	l_on_1.setOnItemSelectedListener(new OnItemSelectedListener() {
	public void onItemSelected(AdapterView<?> arg0, View arg1, 
							   int arg2, long arg3) {
//					int index = h2.getSelectedItemPosition(); 
		Integer index_ll_on_1 = l_on_1.getSelectedItemPosition(); 	
		ll_on_1=hours[index_ll_on_1];
					Toast.makeText(getBaseContext(),
		 "You have selected hours " + ll_on_1, 
		 Toast.LENGTH_SHORT).show();  
	
	}
	public void onNothingSelected(AdapterView<?> arg0) {
	} 
});	
		/*	{
				Button save=(Button)findViewById(R.id.save);
				save.setOnClickListener(new Button.OnClickListener() { 
						public void onClick	(View v) {
							// check if DBC exists




							DBC2.open();
							db.open();


							if (DBC2.insertContact(presidents1, hhh1, lll1, hhh2, status_1,month_picker1,day_picker1,year_picker1, 0, 0, 0,"")>0){
							  
								Toast.makeText(getBaseContext(), "Updated successful: "+presidents1+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
							}
							

							//      if (db.insertContact("Mary Jackson", "mary@jackson.com") >= 0) {
							//          Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
							//      }
							
							if (DBC2.insertContact(presidents22, hhh3, lll2, hhh4, status_2, month_picker1, day_picker1, year_picker1, 0, 0, 0,"")>0){
								Toast.makeText(getBaseContext(), "Updated successful: "+presidents22+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
							}
						
							if (DBC2.insertContact(presidents_on_11, hh_on_1, ll_on_1, hh_on_2,status_on_tm_1, month_picker1, day_picker1, year_picker1,  0, 0, 0,"")>0){
								Toast.makeText(getBaseContext(), "Updated successful: "+presidents_on_11+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
							} 
							DBC2.close();
							db.close();
						}
						
						}


				);
			}
			*/
			
			{	//choose the Month
				month_picker = (Spinner) findViewById(R.id.month_picker);
				
				
				ArrayAdapter<Integer> adapter_month1 = new ArrayAdapter<Integer>(
					this, android.R.layout.simple_spinner_item, month);
				
				
				
					month_picker.setAdapter(adapter_month1);

				month_picker.setOnItemSelectedListener(new OnItemSelectedListener() {
						public void onItemSelected(AdapterView<?> arg0, View arg1, 
												   int arg2, long arg3) {
							index_m= month_picker.getSelectedItemPosition();
							month_picker1=month[index_m];







							{	//choose the Day
								day_picker = (Spinner) findViewById(R.id.day_picker);
								ArrayAdapter<Integer> adapter_day = new ArrayAdapter<Integer>(
									getBaseContext(), android.R.layout.simple_spinner_item, day);
								day_picker.setAdapter(adapter_day);

								day_picker.setOnItemSelectedListener(new OnItemSelectedListener() {
										public void onItemSelected(AdapterView<?> arg0, View arg1, 
																   int arg2, long arg3) {
											index_d= day_picker.getSelectedItemPosition();
											day_picker1=day[index_d];

											Toast.makeText(getBaseContext(),
														   "You have selected hours " + day_picker1, 
														   Toast.LENGTH_SHORT).show();


											{	
												//choose the year
												year_picker = (Spinner) findViewById(R.id.year_picker);
												ArrayAdapter<Integer> year_adapter = new ArrayAdapter<Integer>(
													getBaseContext(), android.R.layout.simple_spinner_item, year);
												year_picker.setAdapter(year_adapter);

												year_picker.setOnItemSelectedListener(new OnItemSelectedListener() {
														public void onItemSelected(AdapterView<?> arg0, View arg1, 
																				   int arg2, long arg3) {
															index_y= year_picker.getSelectedItemPosition();
															year_picker1=year[index_y];

															TextView db_record_check=(TextView)findViewById(R.id.db_record_check);
															db_record_check.setText("      ");

															Button save=(Button)findViewById(R.id.save);
															save.setVisibility(View.VISIBLE);

															Button update=(Button)findViewById(R.id.update);
															update.setVisibility(View.INVISIBLE);

															/*	{ 
															 db_record_check.setVisibility(View.INVISIBLE);
															 }
															 TextView db_record_check=(TextView)findViewById(R.id.db_record_check);
															 db_record_check.setText("      ");
															 */

															DBC2.open();
															Cursor c_row = DBC2.getAllContacts();
															if (c_row.moveToFirst())
															{
																do {
																	//  DisplayContact(c);


																	String mm=c_row.getString(6);
																	Integer mmm=Integer.parseInt(mm.toString());	

																	String dd=c_row.getString(7);
																	Integer ddd=Integer.parseInt(dd.toString());

																	String yy=c_row.getString(8);
																	Integer yyy=Integer.parseInt(yy.toString());


																	nnn=month_picker1-mmm;
																	ooo=day_picker1-ddd;
																	ppp=year_picker1-yyy;
																	//String date=mmm+"/"+ddd+"/"+yyy;

																	/*	 String report=mm+dd+yy;

																	 TextView db_record_check=(TextView)findViewById(R.id.db_record_check);
																	 db_record_check.setText(report); */

																	if ((day_picker1!=null)&&(month_picker1!=null)&&(year_picker1!=null)){
																		if ((ooo==0)&&(nnn==0)&&(ppp==0))

																		{
																			/* { 
																			 db_record_check.setVisibility(View.INVISIBLE);


																			 }
																			 */	
																			//Toast.makeText(getBaseContext(), "Record exists :"+mm+dd+yy+"/ requested :"+month_picker1+day_picker1+year_picker1, Toast.LENGTH_LONG).show();
																			String row1=c_row.getString(0);
																			row_N1=Integer.parseInt(row1.toString());	

																			c_row.moveToNext();

																			String row2=c_row.getString(0);
																			row_N2=Integer.parseInt(row2.toString());	

																			c_row.moveToNext();

																			String row3=c_row.getString(0);
																			row_N3=Integer.parseInt(row3.toString());	

																			TextView db_record_check1=(TextView)findViewById(R.id.db_record_check);
																			db_record_check1.setText("record exists");
																			Button save1=(Button)findViewById(R.id.save);
																			save1.setVisibility(View.INVISIBLE);

																			Button update1=(Button)findViewById(R.id.update);
																			update1.setVisibility(View.VISIBLE);
																			update1.setOnClickListener(new Button.OnClickListener() { 
																					public void onClick	(View v) {
																						// check if DBC exists


																						DBC2.open();





																						if (DBC2.updateContact(row_N1, presidents1, hhh1, lll1, hhh2, status_1,month_picker1,day_picker1,year_picker1, 0, 0, 0,"")){

																							//	Toast.makeText(getBaseContext(), "Updated successful: "+presidents1+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
																						}
																						else 

																						{
																							Toast.makeText(getBaseContext(), "Updated Not successful: ", Toast.LENGTH_LONG).show();
																						}

																						

																						 if (DBC2.updateContact(row_N2, presidents22, hhh3, lll2, hhh4, status_2, month_picker1, day_picker1, year_picker1, 0, 0, 0,"")){
																						 //	Toast.makeText(getBaseContext(), "Updated successful: "+presidents22+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
																						 }

																						 if (DBC2.updateContact(row_N3, presidents_on_11, hh_on_1, ll_on_1, hh_on_2,status_on_tm_1, month_picker1, day_picker1, year_picker1,  0, 0, 0,"")){
																						 //Toast.makeText(getBaseContext(), "Updated successful: "+presidents_on_11+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();

																						 } 
																						 

																					}

																				}


																			);

																		}
																		/*	else
																		 {
																		 //Toast.makeText(getBaseContext(), "Record does not exist ", Toast.LENGTH_LONG).show();
																		 TextView db_record_check=(TextView)findViewById(R.id.db_record_check);
																		 db_record_check.setText("record does not exist");
																		 } 
																		 */
																	}

																} while (c_row.moveToNext());}

															else {

															}
															DBC2.close(); 


														}

														public void onNothingSelected(AdapterView<?> arg0) {
														} 
													});


											}
										}

										public void onNothingSelected(AdapterView<?> arg0) {
										} 
									});
							}
						}

						public void onNothingSelected(AdapterView<?> arg0) {
						} 
					});
			}


			Button save=(Button)findViewById(R.id.save);
			save.setOnClickListener(new Button.OnClickListener() { 
					public void onClick	(View v) {
						// check if DBC exists


						DBC2.open();
						db.open();


						if (DBC2.insertContact(presidents1, hhh1, lll1, hhh2, status_1,month_picker1,day_picker1,year_picker1, 0, 0, 0,"")>0){

							Toast.makeText(getBaseContext(), "Updated successful: "+presidents1+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
						}


						//      if (db.insertContact("Mary Jackson", "mary@jackson.com") >= 0) {
						//          Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
						//      }

						if (DBC2.insertContact(presidents22, hhh3, lll2, hhh4, status_2, month_picker1, day_picker1, year_picker1, 0, 0, 0,"")>0){
							Toast.makeText(getBaseContext(), "Updated successful: "+presidents22+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
						}

						if (DBC2.insertContact(presidents_on_11, hh_on_1, ll_on_1, hh_on_2,status_on_tm_1, month_picker1, day_picker1, year_picker1,  0, 0, 0,"")>0){
							Toast.makeText(getBaseContext(), "Updated successful: "+presidents_on_11+": "+month_picker1+"/"+day_picker1+ " / " + year_picker1, Toast.LENGTH_LONG).show();
						} 
						DBC2.close();
						db.close();
					}

				}


			);
		}

		
			
// report time to enter spinner

		rt = (Spinner) findViewById(R.id.reporttime);

		ArrayAdapter<Integer> adapter9 = new ArrayAdapter<Integer>(
			getBaseContext(), android.R.layout.simple_spinner_item, hours);
		rt.setAdapter(adapter9);

		rt.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<?> arg0, View arg1, 
										   int arg2, long arg3) {
//					int index = h2.getSelectedItemPosition(); 
					rtt = rt.getSelectedItemPosition(); 						   
					Toast.makeText(getBaseContext(),
								   "You have selected hours " + rtt, 
								   Toast.LENGTH_SHORT).show();
				}
				public void onNothingSelected(AdapterView<?> arg0) {
				} 
			});
	}

	public void initControls()

	{

		/*	amount1=(EditText)findViewById(R.id.amount1);

		 amount2=(EditText)findViewById(R.id.amount2);

		 amount3=(EditText)findViewById(R.id.amount3);

		 amount4=(EditText)findViewById(R.id.amount4);
		 */	

		sales=(EditText)findViewById(R.id.sales);

		