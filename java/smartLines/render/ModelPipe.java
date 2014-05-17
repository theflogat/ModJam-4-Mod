package smartLines.render;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelPipe extends ModelBase{
	
	private ArrayList<ModelRenderer> parts = new ArrayList<ModelRenderer>();
	
	public ModelPipe() {
		textureHeight = 256;
		textureWidth = 256;
		
		ModelRenderer core = new ModelRenderer(this, 0, 0);
		core.addBox(-4, -4, -4, 8, 8, 8);
		core.setRotationPoint(-8, -8, 8);
		parts.add(core);
		
		//z -
		ModelRenderer left = new ModelRenderer(this, 0, 16);
		left.addBox(-4, -4, -2, 8, 8, 4);
		left.setRotationPoint(-8, -8, 0);
		parts.add(left);
	}
	
	public void render(float mult){
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}
