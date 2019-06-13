package com.bhabha.thmapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.android.synthetic.main.fragment_1.*
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
import java.io.File


class MainActivity : AppCompatActivity() {

    var docType: String? = null
    var initial: String? = null

    private var datePicker: DatePicker? = null
    private var calendar: Calendar? = null
    private var dateView: TextView? = null
    private var year: Int = 0
    var month: Int = 0
    var day: Int = 0
    private var profileImage: String? = null
    private var profileImageUri: Uri? = null
    private var base64imgprofile: String? = null
    private var mCropImageUri: Uri? = null
    protected var stateprogressbar: StateProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_1)

        stateprogressbar = findViewById(R.id.stateprogressbar) as StateProgressBar
        stateprogressbar!!.setCurrentStateNumber(StateProgressBar.StateNumber.ONE)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (CheckPermission().ischeckandrequestPermission(this@MainActivity)) {
            }
        }


        pic_text!!.setOnClickListener {
            CropImage.startPickImageActivity(this)
        }

        val spinner_doc_type_adapter =
            ArrayAdapter.createFromResource(this, R.array.spinner_doc_type, android.R.layout.simple_spinner_item)
        spinner_doc_type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_doc_type!!.adapter = spinner_doc_type_adapter
        if (spinner_doc_type != null) {
            spinner_doc_type!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    if (adapterView.selectedItemPosition == 0) {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.state_background_color
                            )
                        )
                    } else {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.colorPrimary
                            )
                        )

                    }
                    docType = adapterView.getItemAtPosition(i).toString()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                }
            }
        }


        val spinner_initial_adapter =
            ArrayAdapter.createFromResource(this, R.array.spinner_initial, android.R.layout.simple_spinner_item)
        spinner_initial_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_initial.adapter = spinner_initial_adapter
        if (spinner_initial != null) {
            spinner_initial!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                    if (adapterView.selectedItemPosition == 0) {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.state_background_color
                            )
                        )
                    } else {
                        (adapterView.getChildAt(0) as TextView).setTextColor(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.colorPrimary
                            )
                        )

                    }
                    initial = adapterView.getItemAtPosition(i).toString()
                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                }
            }
        }

        dateView = findViewById(R.id.dob)
        calendar = Calendar.getInstance()
        year = calendar!!.get(Calendar.YEAR)
        month = calendar!!.get(Calendar.MONTH);
        day = calendar!!.get(Calendar.DAY_OF_MONTH)
        dateView!!.setOnClickListener {
            val c = Calendar.getInstance()
            year = c.get(Calendar.YEAR)
            month = c.get(Calendar.MONTH)
            day = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    dateView!!.setText(
                        dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                    )
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
//            showDate(year, month + 1, day)
        }


        btn_nxt.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            profileImageUri = CropImage.getPickImageResultUri(this, data)
            mCropImageUri = profileImageUri
            startCropImageActivity(profileImageUri)
        }

        // handle result of CropImageActivity
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (data != null) {
                val result: CropImage.ActivityResult = CropImage.getActivityResult(data)
                if (resultCode == Activity.RESULT_OK) {
                    val result_uri = result.uri
                    val myFile = File(result_uri.getPath())
                    profilepic!!.setImageURI(result_uri)

                    val selectedcropImage = getImageContentUri(this, myFile)

                    val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                    val cursor =
                        this.getContentResolver().query(selectedcropImage, filePathColumn, null, null, null)
                    cursor.moveToFirst()

                    val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                    profileImage = cursor.getString(columnIndex)
                    cursor.close()

                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Toast.makeText(this, "Cropping failed: " + result.getError(), Toast.LENGTH_LONG).show()
                }
            } else {

            }
        }
    }

    private fun getImageContentUri(context: Context?, myFile: File): Uri? {
        val filePath = myFile.getAbsolutePath()
        val cursor = context!!.getContentResolver().query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            arrayOf<String>(MediaStore.Images.Media._ID),
            MediaStore.Images.Media.DATA + "=? ",
            arrayOf<String>(filePath), null
        )

        if (cursor != null && cursor.moveToFirst()) {
            val id = cursor.getInt(
                cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID)
            )
            val baseUri = Uri.parse("content://media/external/images/media")
            return Uri.withAppendedPath(baseUri, "" + id)
        } else {
            if (myFile.exists()) {
                val values = ContentValues()
                values.put(MediaStore.Images.Media.DATA, filePath)
                return context.getContentResolver().insert(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
                )
            } else {
                return null
            }
        }
    }

    private fun startCropImageActivity(profileImageUri: Uri?) {
        CropImage.activity(profileImageUri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setMultiTouchEnabled(true)
            .setAutoZoomEnabled(true)
            .setAspectRatio(100, 100)
            .setFixAspectRatio(true)
            .setCropShape(CropImageView.CropShape.OVAL)
            .start(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            CheckPermission().permissionCode -> {
                if (grantResults.last() > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                }
            }
        }
    }


}
