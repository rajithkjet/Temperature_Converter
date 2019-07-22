package design.roboleary.conversion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionActivity extends Activity {
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.inputValue);
    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calcButton:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.celsius);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.farenheit);
                TextView output = (TextView) findViewById(R.id.outputValue);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    String result = String.valueOf(ConvertUtil.convertCelsiusToFahrenheit(inputValue));
                    output.setText("= " + result + " farenheit");
                } else {
                    String result = String.valueOf(ConvertUtil.convertFahrenheitToCelsius(inputValue));
                    output.setText("= " + result + " celsius");
                }
                break;
        }
    }
}
