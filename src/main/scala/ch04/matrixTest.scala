package ch04

import org.apache.spark.mllib.linalg.Matrices

/**
  * Created by MKD on 2017/4/15.
  */
object matrixTest {
  def main(args: Array[String]): Unit = {
    val mx = Matrices.dense(2,3,Array(1,2,3,4,5,6))
    println(mx)
  }
}
