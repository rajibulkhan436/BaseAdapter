package com.rajibul.baseadapter

import android.app.Dialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import com.rajibul.baseadapter.databinding.ActivityMainBinding



class MainActivity() : AppCompatActivity() {
    lateinit var baseAdapterClass: baseAdapterClass
    lateinit var binding: ActivityMainBinding
    var studentList= arrayListOf<studentDataClass>()
    lateinit var studentDatabase: StudentDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentDatabase = StudentDatabase.getDatabase(this)
        baseAdapterClass = baseAdapterClass(studentList)
        binding.listview.adapter = baseAdapterClass
        studentList.add(studentDataClass(1, "Rajibul"))
        studentList.add(studentDataClass(2, "Sanket"))
        studentList.add(studentDataClass(3, "Vansh"))
        binding.listview.setOnItemClickListener { adapter, view, position, id ->
            System.out.println("position $position id $id")
            studentList.removeAt(position)
            baseAdapterClass.notifyDataSetChanged()


        }
        binding.fab.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog)
            var etName = dialog.findViewById<EditText>(R.id.etName)
            var btnAdd = dialog.findViewById<Button>(R.id.btnAdd)
            btnAdd.setOnClickListener {
                if(etName.text.toString().isNullOrEmpty()){
                    etName.error = "Enter your name"
                }else{
                    studentList.add(studentDataClass(name = etName.text.toString()))
                    class insertStudent : AsyncTask<Void, Void, Void>(){
                        override fun doInBackground(vararg params: Void?): Void? {

                            studentDatabase.studentDao().insertStudent(studentDataClass(name = etName.text.toString()))
                            dialog.dismiss()
                            return null
                        }
                    }

                    insertStudent().execute()

                    baseAdapterClass.notifyDataSetChanged()
                }
            }
            dialog.show()
        }
    }
    }