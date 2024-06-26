package ec.weka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.SerializationHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ModelService {

	@Autowired
	@Qualifier("ecModelRepository")
	EcModelRepository repository;

    public double predict(String queryInstance) throws Exception {
		
        EcModel ecModel = (EcModel) repository.findByName("weka-lr");
		
        if (ecModel != null) {
            try (InputStream is = new ByteArrayInputStream(ecModel.getObject())) {
                Classifier model = (Classifier) SerializationHelper.read(is);

                Instance query1 = new DenseInstance(6);
                String[] queryValues = queryInstance.split(",");
                for (int i = 0; i < queryValues.length; i++) {
                    query1.setValue(i, Double.parseDouble(queryValues[i]));
                }

                return model.classifyInstance(query1);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Failed", e);
            }
        } else {
            throw new IllegalArgumentException("Model weka-lr not found.");
        }
    }
}
