package com.example.saratchandra.summerinternapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SaratChandra on 6/1/2016.
 */
public class All extends AppCompatActivity implements View.OnClickListener{
    Button first;
    Button second,third,fourth,fifth,sixth,seventh,eighth;
    Button ninth,tenth,eleven,twelve,thirteen,fourteen,fifteen,sixteen;
    Button seventeen,eighteen,nineteen,twenty,twoone,twotwo,twothree,twofour,twofive,twosix,twoseven;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_activity);
        setReferences();
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        fifth.setOnClickListener(this);
        sixth.setOnClickListener(this);
        seventh.setOnClickListener(this);
        eighth.setOnClickListener(this);
        ninth.setOnClickListener(this);
        tenth.setOnClickListener(this);
        eleven.setOnClickListener(this);
        twelve.setOnClickListener(this);
        thirteen.setOnClickListener(this);
        fourteen.setOnClickListener(this);
        fifteen.setOnClickListener(this);
        sixteen.setOnClickListener(this);
        seventeen.setOnClickListener(this);
        eighteen.setOnClickListener(this);
        nineteen.setOnClickListener(this);
        twenty.setOnClickListener(this);
        twoone.setOnClickListener(this);
        twotwo.setOnClickListener(this);
        twothree.setOnClickListener(this);
        twofour.setOnClickListener(this);
        twofive.setOnClickListener(this);
        twosix.setOnClickListener(this);
        twoseven.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public void setReferences(){


        first=(Button)findViewById(R.id.a);
        second=(Button)findViewById(R.id.b);
        third=(Button)findViewById(R.id.c);
        fourth=(Button)findViewById(R.id.d);
        fifth=(Button)findViewById(R.id.e);
        sixth=(Button)findViewById(R.id.f);
        seventh=(Button)findViewById(R.id.g);
        eighth=(Button)findViewById(R.id.h);
        ninth=(Button)findViewById(R.id.i);
        tenth=(Button)findViewById(R.id.j);
        eleven=(Button)findViewById(R.id.k);
        twelve=(Button)findViewById(R.id.l);
        thirteen=(Button)findViewById(R.id.m);
        fourteen=(Button)findViewById(R.id.n);
        fifteen=(Button)findViewById(R.id.o);
        sixteen=(Button)findViewById(R.id.p);
        seventeen=(Button)findViewById(R.id.usage);
        eighteen=(Button)findViewById(R.id.q);
        nineteen=(Button)findViewById(R.id.r);
        twenty=(Button)findViewById(R.id.s);
        twoone=(Button)findViewById(R.id.t);
        twotwo=(Button)findViewById(R.id.u);
        twothree=(Button)findViewById(R.id.v);
        twofour=(Button)findViewById(R.id.w);
        twofive=(Button)findViewById(R.id.x);
        twosix=(Button)findViewById(R.id.y);
        twoseven=(Button)findViewById(R.id.z);
    }
    public void onClick(View v ) {

        switch (v.getId()) {
            case R.id.a:
                Intent ia = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ia);
                break;
            case R.id.b:
                Intent ib = new Intent(getApplicationContext(), CalculateSI.class);
                startActivity(ib);
                break;
            case R.id.c:
                Intent ic = new Intent(getApplicationContext(), Checkboxtest.class);
                startActivity(ic);
                break;
            case R.id.d:
                Intent id = new Intent(getApplicationContext(), SpinnerTask.class);
                startActivity(id);
                break;
            case R.id.e:
                Intent ie = new Intent(getApplicationContext(), Login.class);
                startActivity(ie);
                break;
            case R.id.f:
                Intent i = new Intent(getApplicationContext(), Camera.class);
                startActivity(i);
                break;
            case R.id.g:
                Intent ig = new Intent(getApplicationContext(), ManipulateText.class);
                startActivity(ig);
                break;
            case R.id.h:
                Intent ih = new Intent(getApplicationContext(), Email.class);
                startActivity(ih);
                break;
            case R.id.i:
                Intent ii = new Intent(getApplicationContext(), Message.class);
                startActivity(ii);
                break;
            case R.id.j:
                Intent ij = new Intent(getApplicationContext(), Rating.class);
                startActivity(ij);
                break;
            case R.id.k:
                Intent ik=new Intent(getApplicationContext(),ListViewTask.class);
                startActivity(ik);
                break;
            case R.id.l:
                Intent il=new Intent(getApplicationContext(),Website.class);
                startActivity(il);
                break;
            case R.id.m:
                Intent im=new Intent(getApplicationContext(),ListViewTask.class);
                startActivity(im);
                break;
            case R.id.n:
                Intent in=new Intent(getApplicationContext(),Call.class);
                startActivity(in);
                break;
            case R.id.usage:
                Intent iusage=new Intent(getApplicationContext(),UsageStats.class);
                startActivity(iusage);
                break;
            case R.id.o:
                Intent io=new Intent(getApplicationContext(),SessionManagement.class);
                startActivity(io);
                break;
            case R.id.p:
                Intent ip=new Intent(getApplicationContext(),ManageContacts.class);
                startActivity(ip);
                break;
            case R.id.q:
                Intent iq=new Intent(getApplicationContext(),LoginDatabase.class);
                startActivity(iq);
                break;
            case R.id.r:
                Intent ir=new Intent(getApplicationContext(),LoginTable.class);
                startActivity(ir);
                break;
            case R.id.s:
                Intent is=new Intent(getApplicationContext(),DreamCall.class);
                startActivity(is);
                break;
            case R.id.t:
                Intent it=new Intent(getApplicationContext(),NotificationTime.class);
                startActivity(it);
                break;
            case R.id.u:
                Intent iu=new Intent(getApplicationContext(),GridViewExample.class);
                startActivity(iu);
                break;
            case R.id.v:
                Intent iv=new Intent(getApplicationContext(),JsonExample.class);
                startActivity(iv);
                break;
            case R.id.w:
                Intent iw=new Intent(getApplicationContext(),ContentProviderExample.class);
                startActivity(iw);
                break;
            case R.id.x:
                Intent ix=new Intent(getApplicationContext(),FragmentExample.class);
                startActivity(ix);
                break;
            case R.id.y:
                Intent iy=new Intent(getApplicationContext(),AlertDialogExample.class);
                startActivity(iy);
                break;
            case R.id.z:
                Intent iz=new Intent(getApplicationContext(),ContentProviderExample.class);
                startActivity(iz);
                break;



        }

    }
}
