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
		ModelRenderer zm = new ModelRenderer(this, 0, 16);
		zm.addBox(-4, -4, -2, 8, 8, 4);
		zm.setRotationPoint(-8, -8, 2);
		parts.add(zm);

		//x +
		ModelRenderer zl = new ModelRenderer(this, 0, 28);
		zl.addBox(-2, -4, -4, 4, 8, 8);
		zl.setRotationPoint(-2, -8, 8);
		parts.add(zl);

		//x -
		ModelRenderer xm = new ModelRenderer(this, 0, 16);
		xm.addBox(-4, -4, -2, 8, 8, 4);
		xm.setRotationPoint(-8, -8, 2);
		//parts.add(xm);

		//x +
		ModelRenderer xl = new ModelRenderer(this, 0, 28);
		xl.addBox(-2, -4, -4, 4, 8, 8);
		xl.setRotationPoint(-2, -8, 8);
		//parts.add(xl);
	}

	public void render(float mult){
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}
