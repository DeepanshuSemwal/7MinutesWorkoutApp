package com.example.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.example.a7minworkout.databinding.ActivityBmiBinding
import com.example.a7minworkout.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BmiActivity : AppCompatActivity() {

    private var binding: ActivityBmiBinding?=null

    companion object
    {
        private val metricUnitView="MERTIC_UNIT_VIEW"
        private val usUnitView="US_UNIT_VIEW"
    }
    private var currentVisibleView:String= metricUnitView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.bmiToolBar)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title="Calculate BMI"

        }
        binding?.bmiToolBar?.setNavigationOnClickListener {
            onBackPressed()
        }

        metricVisibleView()
        
        binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId:Int ->

            if(checkedId==R.id.radioMetricUnits)
            {
                metricVisibleView()
            }
            else
            {
                usVisbleView()
            }

        }



        binding?.bmiBtn?.setOnClickListener {
           calculateUnits()

        }


    }

    private fun bmi(bmi:Float)
    {
        val bmiLabel:String
        val bmiDispriction:String

        if(bmi.compareTo(18.5f)<0)
        {
            bmiLabel="Underweight"
            bmiDispriction="indicating your weight is in the Underweight category for adults of your height."

        }
        else if(bmi.compareTo(18.5)>=0 && bmi.compareTo(24.9f)<=0)
        {
            bmiLabel="Normal"
            bmiDispriction="indicating your weight is in the Healthy category for adults of your height."

        }
        else if(bmi.compareTo(25)>=0 && bmi.compareTo(29.9)<=0 )
        {
            bmiLabel="Overweight"
            bmiDispriction="indicating your weight is in the Overweight category for adults of your height."
        }
        else
        {
            bmiLabel="Obese"
            bmiDispriction="indicating your weight is in the Obese category for adults of your height."

        }

        // setscale like 25.21
         val bmiValue=BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.bmiDisplay?.visibility=View.VISIBLE
        binding?.bmiResult?.text=bmiValue
        binding?.bmiType?.text=bmiLabel
        binding?.bmiDis?.text=bmiDispriction

    }

    private fun validateInputMetric():Boolean
    {
        var isvaild=true

        if(binding?.editTextWeight?.text.toString().isEmpty())
        {
            isvaild=false
        }
        else if(binding?.editTextHeight?.text.toString().isEmpty())
        {
            isvaild=false
        }

        return isvaild

    }

    private fun validateInputUS():Boolean
    {
        var isvalid=true

        if(binding?.editTextWeightUS?.text.toString().isEmpty())
        {
            isvalid=false
        }
        else if(binding?.editTextUsMetricUnitHeightFeet?.text.toString().isEmpty())
        {
            isvalid=false
        }
        else if(binding?.editTextUsMetricUnitHeightInch?.text.toString().isEmpty())
        {
            isvalid=false
        }
        return isvalid

    }


    private fun metricVisibleView()
    {
        currentVisibleView= metricUnitView
        binding?.weightUnitMetric?.visibility=View.VISIBLE
        binding?.heightMetricUnit?.visibility=View.VISIBLE
        binding?.weightUnitUS?.visibility=View.GONE

        binding?.metricUsUnitHeightFeet?.visibility=View.GONE
        binding?.metricUsUnitHeightInch?.visibility=View.GONE

        binding?.editTextWeight?.text!!.clear()
        binding?.editTextHeight?.text!!.clear()

        binding?.bmiDisplay?.visibility=View.INVISIBLE

    }

    private fun usVisbleView()
    {
        currentVisibleView= usUnitView
        binding?.weightUnitMetric?.visibility=View.INVISIBLE
        binding?.heightMetricUnit?.visibility=View.INVISIBLE

        binding?.metricUsUnitHeightFeet?.visibility=View.VISIBLE
        binding?.metricUsUnitHeightInch?.visibility=View.VISIBLE
        binding?.weightUnitUS?.visibility=View.VISIBLE

        binding?.editTextUsMetricUnitHeightFeet?.text!!.clear()
        binding?.editTextUsMetricUnitHeightInch?.text!!.clear()
        binding?.editTextWeightUS?.text!!.clear()

        binding?.bmiDisplay?.visibility=View.INVISIBLE


    }


    private fun calculateUnits()
    {
        if(currentVisibleView== metricUnitView)
        {
            if(validateInputMetric())
            {
                val metricWeight:Float=binding?.editTextWeight?.text.toString().toFloat()
                val metricHeight:Float=binding?.editTextHeight?.text.toString().toFloat()/100
                val bmiValue=metricWeight/(metricHeight*metricHeight)
                bmi(bmiValue)

            }
            else
            {
                Toast.makeText(this@BmiActivity,"please enter the valid values.",Toast.LENGTH_SHORT).show()
            }

        }
        else if(currentVisibleView== usUnitView)
        {
            if(validateInputUS())
            {
                val usWeight:Float=binding?.editTextWeightUS?.text.toString().toFloat()
                val usHeightFeet:String=binding?.editTextUsMetricUnitHeightFeet?.text.toString()
                val usHeightInch:String=binding?.editTextUsMetricUnitHeightInch?.text.toString()
                val heightValue:Float=usHeightInch.toFloat()+usHeightFeet.toFloat()*12

                val bmiValue=(usWeight/(heightValue*heightValue))*703

                bmi(bmiValue)

            }
            else
            {
                Toast.makeText(this@BmiActivity,"please enter the valid values.",Toast.LENGTH_SHORT).show()
            }

        }

    }
}

