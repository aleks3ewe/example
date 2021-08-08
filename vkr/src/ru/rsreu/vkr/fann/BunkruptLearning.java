package ru.rsreu.vkr.fann;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.fannj.ActivationFunction;
import com.googlecode.fannj.Fann;
import com.googlecode.fannj.Layer;
import com.googlecode.fannj.Trainer;
import com.googlecode.fannj.TrainingAlgorithm;

public class BunkruptLearning {
	public static void learning(String[] args) {
        //Add layers
        List<Layer> layerList = new ArrayList<Layer>();
        layerList.add(Layer.create(4, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layerList.add(Layer.create(1, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        Fann fann = new Fann(layerList);
        //Add trainer
        Trainer trainer = new Trainer(fann);
        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);
        // Learning
        trainer.train(new File("train.data").getAbsolutePath(), 100000, 1000, 0.0001f);
        fann.save("ann");
	}
}
