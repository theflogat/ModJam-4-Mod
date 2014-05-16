package smartLines.render;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPipe extends ModelBase{
	
	private ArrayList<ModelRenderer> parts = new ArrayList<ModelRenderer>();
	
	public void render(float mult){
		
		
		ModelRenderer core = new ModelRenderer(this, 0, 0);
		core.addBox(0, 0, 0, 0, 0, 0);
		core.setRotationPoint(0, 0, 0);
		parts.add(core);
	}
}
