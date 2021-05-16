package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list2.*
import kotlinx.android.synthetic.main.list_item_course.view.*

class ListActivity : AppCompatActivity() {

    private val courses = listOf(
        Course("Android", "Praveen", 12, 876),
        Course("Reactjs", "Nishi", 23, 90),
        Course("Flutter", "harsh", 45, 756),
        Course("Java", "Animesh", 345, 234),
        Course("Java", "Animesh", 345, 234),
        Course("Kotlin", "Rajiv", 43, 345345),
        Course("C++", "Arnav", 3, 345),
        Course("C++", "Arnav", 3, 345),
        Course("Nodejs", "Pulkit", 345, 546),
        Course("Express", "Rana", 43, 464),
        Course("Express", "Rana", 43, 464),
        Course("Erlang", "Tiwari", 3, 2346),
        Course("Erlang", "Tiwari", 3, 2346),
        Course("Erlang", "Tiwari", 3, 2346),
        Course("MySQL", "Yash", 34, 234),
        Course("MySQL", "Yash", 34, 234),
    )

//    private val courses = listOf("Android", "Python", "Java",
//            "C++", "ReactJs", "Spring", "Kotlin",
//            "Erlang", "ViewMode", "ML", "AL",
//            "Big Data", "C#", "flutter", "Native",
//            "Linux", "Heoku", "AWS", "Digital "
//        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list2)



//        listCourses.adapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            android.R.id.text1,
//            courses
//        )

        listCourses.adapter = object : BaseAdapter() {
            override fun getCount() = courses.size;

            override fun getItem(position: Int): Course = courses[position];

            override fun getItemId(position: Int): Long = getItem(position).hashCode().toLong();

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val itemView = layoutInflater.inflate(R.layout.list_item_course, parent, false)
                val course = getItem(position)
                itemView.tvCourseName.text = course.name
                itemView.tvTutor.text = course.tutor
                itemView.tvCourseDetail.text = "Lectures: ${course.lectures} | Fees: ${course.fees}"

                return  itemView;
            }

        }

        listCourses.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Clicked on ${courses[position]}", Toast.LENGTH_SHORT).show();
        }

    }
}