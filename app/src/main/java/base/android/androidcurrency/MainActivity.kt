package base.android.androidcurrency

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.util.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener


class MainActivity : AppCompatActivity() {

    private lateinit var amount: EditText
    private lateinit var currency_result: TextView
    private lateinit var currency: Spinner
    private lateinit var currentCountry: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amount = findViewById(R.id.amount) as EditText
        currency = findViewById(R.id.currency_spinner) as Spinner
        currency_result = findViewById(R.id.currency_result) as TextView

        currentCountry = "US"

        populateSpinner()
        attachListeners()
    }

    fun attachListeners() {
        amount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                currency_result.setText(CurrencyConverter.displayCurrency("en", currency.getItemAtPosition(currency.getSelectedItemPosition()).toString(), s.toString()));
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    fun validate() {

    }

    fun populateSpinner() {
        val mAdapter = ArrayAdapter.createFromResource(this, R.array.countryISOS, android.R.layout.simple_spinner_item)
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        currency.setAdapter(mAdapter)
    }


}
