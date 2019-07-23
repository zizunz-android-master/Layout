# hello, This is LayoutSample Project with Zizunz Android Master organization.

----
## what is ConstraintLayout?
see [Docs](https://developer.android.com/training/constraint-layout)

> Constraint 을 정의해서 뷰들의 관계를 나타내고, 레이아웃을 구성한다.

----
## why ConstraintLayout?
1. 뷰들의 계층 구조를 단순화한다. == Child 뷰의 수를 줄이고, 하나의 Layout에 모든 뷰들을 나타낼 수 있다.
2. RelativeLayout과 비교했을 때, 더 간편한 사용이 가능하다.
여러 기기에 앱을 출시할 때 유연한 레이아웃 구성을 가능하게 해준다. 
3. FrameLayout, RelativeLayout, LinearLayout 등을 쉽게 대체할 수 있다.

----
## usage

    <ImageView
            app:layout_constraintDimensionRatio="1"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:srcCompat="@drawable/sun"
            android:id="@+id/sun"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintHorizontal_bias="0.5"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintWidth_percent="0.7"
            />

    <ImageView
            app:layout_constraintDimensionRatio="1"
            app:layout_constraintWidth_percent="0.1"
            app:srcCompat="@drawable/mercury"

            app:layout_constraintCircle="@id/sun"
            app:layout_constraintCircleRadius="80dp"
            app:layout_constraintCircleAngle="0"

            android:layout_width="0dp"
            android:layout_height="0dp"
            android:id="@+id/mercury"/>

    <ImageView
            app:layout_constraintDimensionRatio="1"
            app:layout_constraintWidth_percent="0.1"
            app:srcCompat="@drawable/venus"

            app:layout_constraintCircle="@id/sun"
            app:layout_constraintCircleRadius="120dp"
            app:layout_constraintCircleAngle="90"

            android:layout_width="0dp"
            android:layout_height="0dp"
            android:id="@+id/venus"/>

    <ImageView

            app:layout_constraintWidth_percent="0.15"
            app:layout_constraintDimensionRatio="1"
            android:alpha="0.1"
            android:layout_width="0dp"
            android:layout_height="0dp"
            app:srcCompat="@drawable/ziwon"
            android:id="@+id/imageView2"
            app:layout_constraintEnd_toEndOf="@+id/sun"
            app:layout_constraintStart_toStartOf="@+id/sun"
            app:layout_constraintBottom_toBottomOf="@+id/sun"
            app:layout_constraintTop_toTopOf="@+id/sun"/>


![Planet](https://github.com/zizunz-android-master/Layout/blob/master/images/planet.jpg "Planet")
![Page1](https://github.com/zizunz-android-master/Layout/blob/master/images/page1.jpg "Page1")
![Page2](https://github.com/zizunz-android-master/Layout/blob/master/images/page2.jpg "Page2")
![Page3](https://github.com/zizunz-android-master/Layout/blob/master/images/page3.jpg "Page3")
