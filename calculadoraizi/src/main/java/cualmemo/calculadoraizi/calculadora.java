package cualmemo.calculadoraizi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class calculadora extends AppCompatActivity {
    protected int resultado,num1,num2,state;
    EditText etnum1, etnum2,etresult;
    Button bcalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        /*TextView texto= new TextView(this);
        texto.setText("holapaurrros");
        setContentView(texto);*/
        etnum1 = (EditText) findViewById(R.id.etnum1);
        etnum2 = (EditText) findViewById(R.id.etnum2);
        etresult =(EditText) findViewById(R.id.etresult);
        bcalc =(Button)findViewById(R.id.button);
        state =5;


    }
    public void onRadioButtonClicked(View vista) {
        // Is the button now checked?
        boolean checked = ((RadioButton) vista).isChecked();

        // Check which radio button was clicked
        switch(vista.getId()) {
            case R.id.rbsuma:
                if (checked)
                   state=1;
                    break;
            case R.id.rbresta:
                if (checked)
                    state=2;
                    break;
            case R.id.rbmult:
                if (checked)
                    state=3;
                break;
            case R.id.rbdiv:
                if (checked)
                    state=4;
                break;

        }
    }

    public void hacerCalc (View vista){
        String Setnum1 = etnum1.getText().toString();
        String Setnum2 = etnum2.getText().toString();
        int state2=state;
        if (TextUtils.isEmpty(Setnum1)||TextUtils.isEmpty(Setnum2)){
            state2=5;
        }
        else
        {
             num1 = Integer.parseInt(etnum1.getText().toString());
             num2 = Integer.parseInt(etnum2.getText().toString());
        }
       switch (state2){
            case 1:
                resultado = num1 + num2;
                etresult.setText(Integer.toString(resultado));
                break;
            case 2:
                resultado = num1 - num2;
                etresult.setText(Integer.toString(resultado));
                break;
            case 3:
                resultado = num1 * num2;
                etresult.setText(Integer.toString(resultado));

                break;
            case 4:
                if(num2==0) {
                    etresult.setText("");
                    Toast.makeText(this,"No se puede dividir por cero .-.", Toast.LENGTH_SHORT).show();
                }
                else {
                    resultado = num1 / num2;
                    etresult.setText(Integer.toString(resultado));
                }
                break;
            case 5:
                etresult.setText("");
                Toast.makeText(this,"elementos vacíos .-.", Toast.LENGTH_SHORT).show();
                break;
        }
       //    eMessage.setText(String.valueOf(message)); opcion1


   }
}
