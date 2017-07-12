package com.beeva.SpringBatch.SpringBatch.fileProcessor.process;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.beeva.SpringBatch.SpringBatch.job.fileProcessor.models.Empleado;

@Component
public class FileProcess  implements ItemProcessor<Empleado,Empleado>{
	
	public Empleado process(Empleado empleado){
		return empleado;
	}
	
	
}
