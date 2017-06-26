package ch13

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.clustering.GaussianMixture
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.classification.NaiveBayesModel
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yousa on 2017/6/26.
  */
object irisBayes {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisBayes")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc,"E://work//SparkMLlib//data//IrisBayes.txt")
    val model = NaiveBayes.train(data,1.0)
    val test = Vectors.dense(7.3,2.9,6.3,1.8)
    val result = model.predict(test)
  }
}
