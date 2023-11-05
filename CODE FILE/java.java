import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.io.File;

public class ImageAnalysis {

    public static void main(String[] args) throws Exception {
        // Load a pre-trained Keras model (e.g., MobileNetV2)
        ComputationGraph model = KerasModelImport.importKerasModelAndWeights("path_to_model.h5", false);

        // Load and preprocess the image
        File imageFile = new File("path_to_image.jpg");
        NativeImageLoader imageLoader = new NativeImageLoader(224, 224, 3);
        INDArray image = imageLoader.asMatrix(imageFile);

        // Make predictions on the image
        INDArray predictions = model.output(image);

        // Process and display the predictions
        System.out.println("Top Predictions:");
        System.out.println(predictions);
    }
}
