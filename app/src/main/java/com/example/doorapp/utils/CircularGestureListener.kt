package com.example.doorapp.utils

import android.content.Context
import android.graphics.PointF
import android.view.MotionEvent
import android.view.View
import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt

abstract class CircularGestureListener(ctx : Context) : View.OnTouchListener {

    private val touchPoints = mutableListOf<PointF>()
    private val MIN_CIRCLE_POINTS = 10 //minimum "points" needed for it to considering if its a circle or not
    private val RADIUS_THRESHOLD = 50 //minimum correctness of the circle itself

    abstract fun onCircularGesture()
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                touchPoints.add(PointF(event.x,event.y))
            }
            MotionEvent.ACTION_UP ->  {
                if (isCircularGesture(touchPoints)) {
                    onCircularGesture()
                }
                touchPoints.clear()
            }
        }
        return true
    }

     fun isCircularGesture(touchPoints: List<PointF>): Boolean {
        if (touchPoints.size < MIN_CIRCLE_POINTS) return false

         //calculate centroid
         val centroid = calculateCentroid(touchPoints)

         //calculate radius to cehck for consistency
         val radius = touchPoints.map { pointF -> calculateDistance(pointF, centroid) }
        val avgRadius = radius.average()
         if (radius.any { kotlin.math.abs(it - avgRadius) > RADIUS_THRESHOLD }) return false

         // Calculate angles and check for circular distribution
         val angles = touchPoints.map { point -> atan2(point.y - centroid.y, point.x - centroid.x) }
         val sortedAngles = angles.sorted()
         val angleDifferences = mutableListOf<Double>()

         for (i in 0 until sortedAngles.size - 1) {
             angleDifferences.add((sortedAngles[i + 1] - sortedAngles[i]).toDouble())
         }
         angleDifferences.add(2 * Math.PI - sortedAngles.last() + sortedAngles.first())

         val avgAngleDiff = angleDifferences.average()
         return angleDifferences.all { kotlin.math.abs(it - avgAngleDiff) < 0.1 }
     }
     }

    fun calculateDistance(p1: PointF, p2: PointF) : Float {
        return sqrt((p1.x - p2.x).pow(2) + (p1.y - p2.y).pow(2))
    }

    fun calculateCentroid(touchPoints: List<PointF>): PointF {
        val x = touchPoints.map { it.x }.average()
        val y = touchPoints.map { it.y }.average()
        return  PointF(x.toFloat(), y.toFloat())
    }



