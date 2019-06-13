package com.bhabha.thmapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.theartofdev.edmodo.cropper.CropImage
import java.util.*
import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.*
import com.kofigyan.stateprogressbar.StateProgressBar
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.fragment_2.*
import java.io.File


class MainActivity2 : AppCompatActivity() {

    var docType: String? = null
    var initial: String? = null
//    var initial: String? = null

    protected var stateprogressbar: StateProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_2)

        stateprogressbar = findViewById(R.id.stateprogressbar) as StateProgressBar
        stateprogressbar!!.setCurrentStateNumber(StateProgressBar.StateNumber.TWO)


        val spinner_marital_adapter =
            ArrayAdapter.createFromResource(this, R.array.spinner_marital, android.R.layout.simple_spinner_item)
        spinner_marital_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_marital!!.adapter = spinner_marital_adapter
        if (spinner_marital != null) {
            spinner_marital!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    if (adapterView.selectedItemPosition == 0) {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity2,
                                R.color.state_background_color
                            )
                        )
                    } else {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity2,
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


        val spinner_education_adapter =
            ArrayAdapter.createFromResource(this, R.array.spinner_education, android.R.layout.simple_spinner_item)
        spinner_education_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_education.adapter = spinner_education_adapter
        if (spinner_education != null) {
            spinner_education!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    if (adapterView.selectedItemPosition == 0) {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity2,
                                R.color.state_background_color
                            )
                        )
                    } else {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity2,
                                R.color.colorPrimary
                            )
                        )

                    }
//                    initial = adapterView.getItemAtPosition(i).toString()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                }
            }


            val spinner_occupation_adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_occupation, android.R.layout.simple_spinner_item)
            spinner_occupation_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_occupation.adapter = spinner_occupation_adapter
            if (spinner_occupation != null) {
                spinner_occupation!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
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
 val spinner_nationality_adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_nationality, android.R.layout.simple_spinner_item)
            spinner_nationality_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_nationality.adapter = spinner_nationality_adapter
            if (spinner_nationality != null) {
                spinner_nationality!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
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
            val spinner_religion_adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_religion, android.R.layout.simple_spinner_item)
            spinner_religion_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_religion.adapter = spinner_religion_adapter
            if (spinner_religion != null) {
                spinner_religion!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
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
 val spinner_mother_tongue_adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_mother_tongue, android.R.layout.simple_spinner_item)
            spinner_mother_tongue_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_mother_tongue.adapter = spinner_mother_tongue_adapter
            if (spinner_mother_tongue != null) {
                spinner_mother_tongue!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
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
 val spinner_reffer_adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_reffer, android.R.layout.simple_spinner_item)
            spinner_reffer_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_reffer.adapter = spinner_reffer_adapter
            if (spinner_reffer != null) {
                spinner_reffer!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
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
 val spinner_reffer_for_adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_reefer_for, android.R.layout.simple_spinner_item)
            spinner_reffer_for_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_reffer_for.adapter = spinner_reffer_for_adapter
            if (spinner_reffer_for != null) {
                spinner_reffer_for!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                        if (adapterView.selectedItemPosition == 0) {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
                                    R.color.state_background_color
                                )
                            )
                        } else {
                            (adapterView.getChildAt(0) as TextView).setTextColor(
                                ContextCompat.getColor(
                                    this@MainActivity2,
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
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        btn_next.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent)
//        }
        }
    }
}
}
