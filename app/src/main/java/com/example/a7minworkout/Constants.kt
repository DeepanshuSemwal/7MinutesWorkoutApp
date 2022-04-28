package com.example.a7minworkout

object Constants {

    fun defaultExerciseList():ArrayList<ExcerciseModel>
    {
        val excerciselist=ArrayList<ExcerciseModel>()
        val jumingjacks=ExcerciseModel(

            1,
        "Jumping Jacks",
            R.drawable.jumpingjacks,
            false,
            false
        )
        excerciselist.add(jumingjacks)

        val wallsit=ExcerciseModel(
            2,
        "Wall Sit",
            R.drawable.wallsit,
            false,
            false
        )
        excerciselist.add(wallsit)

        val pushup=ExcerciseModel(
            3,
        "Push-up",
            R.drawable.pushups,
            false,
            false
        )
        excerciselist.add(pushup)

        val abdominlacrunch=ExcerciseModel(
            4,
        "Abdominal crunch",
            R.drawable.abdominalcrunches,
            false,
            false
        )
        excerciselist.add(abdominlacrunch)

        val setup=ExcerciseModel(
            5,
            "Step-up onto chair",
            R.drawable.setpup,
            false,
            false

        )
        excerciselist.add(setup)

        val squat=ExcerciseModel(
            6,
            "Squat",
            R.drawable.squats,
            false,
            false
        )
        excerciselist.add(squat)

        val tricpesdips=ExcerciseModel(
            7,
            "Triceps dip on chair ",
            R.drawable.tricpesdips,
            false,
            false
        )
        excerciselist.add(tricpesdips)

        val plank=ExcerciseModel(
            8,
            "Plank",
            R.drawable.plank,
            false,
            false
        )
        excerciselist.add(plank)

        val highkness=ExcerciseModel(
            9,
            "High knees/running in place ",
            R.drawable.highknees,
            false,
            false
        )
        excerciselist.add(highkness)

        val lunge=ExcerciseModel(
            10,
            "Lunge",
            R.drawable.lunge,
            false,
            false
        )
        excerciselist.add(lunge)

        val pushuprotation=ExcerciseModel(
            11,
            "Push-up and rotation ",
            R.drawable.pushuprotation,
            false,
            false
        )
        excerciselist.add(pushuprotation)

        val sideplank=ExcerciseModel(
            12,
            "Side plank",
            R.drawable.sideplank,
            false,
            false
        )
        excerciselist.add(sideplank)


        return excerciselist


    }
}