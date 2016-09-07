package cualmemo.formulario;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu_Form extends AppCompatActivity {
    EditText etUsuario,etPass,etRpass,etCorreo;
    TextView tvUsuario,tvCorreo,tvGene,tvLugar,tvHobbi,tvFecha2;
    Button  bAcept;
    int stado;
    int flagG;
    int flagRb;
     int contt;
    int flagok;
    final String fecha2="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__form);

        stado=5;
        contt=0;
        flagok=0;
        etUsuario=(EditText)findViewById(R.id.etusuario);
        etPass=(EditText)findViewById(R.id.etpass);
        etRpass=(EditText)findViewById(R.id.etrpass);
        etCorreo=(EditText)findViewById(R.id.etcorreo);

        tvUsuario =(TextView)findViewById(R.id.tvusuario);
        tvCorreo =(TextView)findViewById(R.id.tvcorreo);
        tvGene =(TextView)findViewById(R.id.tvgene);
        tvLugar =(TextView)findViewById(R.id.tvlugar);
        tvHobbi =(TextView)findViewById(R.id.tvhobbi);
        tvFecha2=(TextView)findViewById(R.id.tvfecha);

        Spinner spinner = (Spinner) findViewById(R.id.city_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.city_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        bAcept =(Button)findViewById(R.id.bacept);


        bAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String Sfechaf = tvFecha2.getText().toString();

            if (TextUtils.isEmpty(Sfechaf)) {
                Toast.makeText(getApplicationContext(),"Falta la fecha .-.", Toast.LENGTH_SHORT).show();
                contt =0;
            }
            else{
                contt +=1;
            }
            String Susuario= etUsuario.getText().toString();
            String Spass= etPass.getText().toString();
            String Srpass= etRpass.getText().toString();
            String Scorreo= etCorreo.getText().toString();

            if (TextUtils.isEmpty(Susuario)||TextUtils.isEmpty(Spass)||TextUtils.isEmpty(Srpass)||TextUtils.isEmpty(Scorreo)) {
                Toast.makeText(getApplicationContext(),"Elementos vacíos .-.", Toast.LENGTH_SHORT).show();
                contt =0;
            }
            else {
                contt +=1;
            }
            if(flagRb==0){
                contt =0;
                Toast.makeText(getApplicationContext(),"Género vacío .-.", Toast.LENGTH_SHORT).show();
            }
            else {

                contt +=1;
            }
            if(contt==3){
                Toast.makeText(getApplicationContext(),"estás acá .-.", Toast.LENGTH_SHORT).show();
                if(Spass.equals(etRpass.getText().toString())){
                    flagok =1;
                    tvUsuario.setText(etUsuario.getText());
                    tvCorreo.setText(etCorreo.getText());
                    switch (flagG){
                        case 1:
                            tvGene.setText("masculino");
                            break;
                        case 2:
                            tvGene.setText("femenino");
                            break;
                    }
                    tvLugar.setText("falta el lugar");
                    tvHobbi.setText("falta los hobbies");

                }
                else {
                    Toast.makeText(getApplicationContext(),"Contraseña incorrecta .-.", Toast.LENGTH_SHORT).show();
                }
                contt =0;

            }
        }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        flagRb =1;
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rbmasc:
                if (checked) {
                    flagG = 1;
                }
                break;
            case R.id.rbfem:
                if (checked){
                    flagG = 2;
                }
            break;
        }
    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        //static int conee=contt;
        @Override

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker

            final java.util.Calendar c = java.util.Calendar.getInstance();
            int year = c.get(java.util.Calendar.YEAR);
            int month = c.get(java.util.Calendar.MONTH);
            int day = c.get(java.util.Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            final  TextView tvFecha  =(TextView)getActivity().findViewById(R.id.tvfecha);
            String mes="", día ="";
            switch (month){
                case 0:
                    mes=" de Enero de ";
                    break;
                case 1:
                    mes=" de Febrero de ";
                    break;
                case 2:
                    mes=" de Marzo de ";
                    break;
                case 3:
                    mes=" de Abril de ";
                    break;
                case 4:
                    mes=" de Mayo de ";
                    break;
                case 5:
                    mes=" de Junio de ";
                    break;
                case 6:
                    mes=" de Julio de ";
                    break;
                case 7:
                    mes=" de Agosto de ";
                    break;
                case 8:
                    mes=" de Septiembre de ";
                    break;
                case 9:
                    mes=" de Octubre de ";
                    break;
                case 10:
                    mes=" de Noviembre de ";
                    break;
                case 11:
                    mes=" de Diciembre  de ";
                    break;

            }

            final String año = String.valueOf(year);
            final String dia = String.valueOf(day);
            final String mes2 = mes;
            String Fecha= dia + mes2+ año;

            tvFecha.setText(Fecha);
        }
    }
    public void showDatePickerDialog(View v) {

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(),"datePicker");

    }


}
