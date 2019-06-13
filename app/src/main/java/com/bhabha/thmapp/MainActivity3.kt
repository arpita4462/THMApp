package com.bhabha.thmapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.content.Intent
import android.widget.*
import com.kofigyan.stateprogressbar.StateProgressBar
import kotlinx.android.synthetic.main.fragment_3.*


class MainActivity3 : AppCompatActivity() {

    var docType: String? = null
    var initial: String? = null
//    var initial: String? = null

    protected var stateprogressbar: StateProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_3)

        stateprogressbar = findViewById(R.id.stateprogressbar) as StateProgressBar
        stateprogressbar!!.setCurrentStateNumber(StateProgressBar.StateNumber.THREE)


        val spinner_country_adapter =
            ArrayAdapter.createFromResource(this, R.array.country_arrays, android.R.layout.simple_spinner_item)
        spinner_country_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_country!!.adapter = spinner_country_adapter
        if (spinner_country != null) {
            spinner_country!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    if (adapterView.selectedItemPosition == 0) {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity3,
                                R.color.state_background_color
                            )
                        )
                    } else {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity3,
                                R.color.colorPrimary
                            )
                        )

                    }
//                    docType = adapterView.getItemAtPosition(i).toString()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                }
            }
        }


        val spinner_state_adapter =
            ArrayAdapter.createFromResource(this, R.array.india_state_arrays, android.R.layout.simple_spinner_item)
        spinner_state_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_state.adapter = spinner_state_adapter
        if (spinner_state != null) {
            spinner_state!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    if (adapterView.selectedItemPosition == 0) {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity3,
                                R.color.state_background_color
                            )
                        )
                    } else {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity3,
                                R.color.colorPrimary
                            )
                        )

                    }
//                    initial = adapterView.getItemAtPosition(i).toString()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                }
            }


            val spinner_District_adapter =
                ArrayAdapter.createFromResource(this, R.array.distric_arrays, android.R.layout.simple_spinner_item)
            spinner_District_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_District.adapter = spinner_District_adapter
            if (spinner_District != null) {
                spinner_District!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity3,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity3,
                                    R.color.colorPrimary
                                )
                            )

                        }
//                    initial = adapterView.getItemAtPosition(i).toString()
                    }

                    override fun onNothingSelected(adapterView: AdapterView<*>) {
                    }
                }
            }


            btn_back.setOnClickListener {
                val intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)
            }
            btn_next.setOnClickListener {
                val intent = Intent(applicationContext, MainActivity4::class.java)
                startActivity(intent)
//        }
            }
        }
    }
}
