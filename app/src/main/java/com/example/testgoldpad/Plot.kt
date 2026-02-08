package com.example.testgoldpad

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.math.abs

class Plot: Fragment() {
    lateinit var ParValue: TextView
    lateinit var NumberOfHit: TextView
    lateinit var Message: TextView
    lateinit var CoordinatesOfBall: TextView
    lateinit var Longitude: TextView
    lateinit var Latitude: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.plot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ParValue = view.findViewById(R.id.ParValue)
        CoordinatesOfBall = view.findViewById(R.id.CoordinatesOfBall)
        Longitude = view.findViewById(R.id.Longitude)
        Latitude = view.findViewById(R.id.Latitude)
        NumberOfHit = view.findViewById(R.id.Hit)
        Message = view.findViewById(R.id.messsange)

        val ButtonPlay = view.findViewById<Button>(R.id.button2)
        ButtonPlay.setOnClickListener {

            try {
                val parIntValue: Int = ParValue.text.toString().toInt()
                val numberOfHit: Int = NumberOfHit.text.toString().toInt()

                val CoordinatesOfBall = CoordinatesOfBall.text.toString()
                val BallLongitude = CoordinatesOfBall.split(" ").map {it.trim()}
                val ballLongitude: Float = BallLongitude[0].toFloat()
                val BallLatitude =  CoordinatesOfBall.split(" ").map {it.trim()}
                val ballLatitude: Float = BallLatitude[1].toFloat()

                val Longitude= Longitude.text.toString()
                val longitude = Longitude.split(" ").map {it.trim()}
                val longitude0: Float = longitude[0].toFloat()
                val longitude1: Float = longitude[1].toFloat()
                val longitude2: Float = longitude[2].toFloat()

                val Latitude = Latitude.text.toString()
                val latitude =  Latitude.split(" ").map {it.trim()}
                val latitude0: Float = latitude[0].toFloat()
                val latitude1: Float = latitude[1].toFloat()
                val latitude2: Float = latitude[2].toFloat()

                val GreenWidth:Float = latitude2-latitude0/2
                val LeftWidth:Float = longitude1 - GreenWidth
                val RightWidth:Float = longitude1+ GreenWidth
                if(abs(longitude0)<=abs(ballLongitude) && abs(ballLongitude) <= abs(longitude2) ) {
                    if (parIntValue-2 >= numberOfHit && (abs(LeftWidth)<=abs(ballLatitude) && abs(ballLatitude)<= abs(RightWidth))) {
                            Message.text = "You gave GIR ! "
                        }
                    else{
                        Message.text = "You didn't give GIR ! "
                    }
                }

                else {Message.text = "You didn't give GIR!The ball missed the green! "}

            } catch (e: NumberFormatException) {
                Message.text = "An error occurred"
            }
        }
    }
}

