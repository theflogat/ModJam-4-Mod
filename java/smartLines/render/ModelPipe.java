package smartLines.render;

import java.util.ArrayList;

import smartLines.api.SIDE;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.RotationHelper;

public class ModelPipe extends ModelBase{

	private ModelRenderer core;
	private ModelRenderer[] cons = new ModelRenderer[6];

	public ModelPipe() {
		textureHeight = 256;
		textureWidth = 256;

		core = new ModelRenderer(this, 0, 0);
		core.addBox(-4, -4, -4, 8, 8, 8);
		core.setRotationPoint(-8, -8, 8);

		//z -
		ModelRenderer zm = new ModelRenderer(this, 0, 16);
		zm.addBox(-4, -4, -2, 8, 8, 4);
		zm.setRotationPoint(-8, -8, 2);
		cons[SIDE.getSideFromDir(ForgeDirection.NORTH)] = zm;

		//x -
		ModelRenderer xm = new ModelRenderer(this, 0, 28);
		xm.addBox(-2, -4, -4, 4, 8, 8);
		xm.setRotationPoint(-2, -8, 8);
		cons[SIDE.getSideFromDir(ForgeDirection.WEST)] = xm;

		//z +
		ModelRenderer zl = new ModelRenderer(this, 0, 16);
		zl.addBox(-4, -4, -2, 8, 8, 4);
		zl.setRotationPoint(-8, -8, 14);
		zl.rotateAngleY = (float) (Math.PI);
		cons[SIDE.getSideFromDir(ForgeDirection.SOUTH)] = zl;

		//x +
		ModelRenderer xl = new ModelRenderer(this, 0, 28);
		xl.addBox(-2, -4, -4, 4, 8, 8);
		xl.setRotationPoint(-14, -8, 8);
		xl.rotateAngleY = (float) (Math.PI);
		cons[SIDE.getSideFromDir(ForgeDirection.EAST)] = xl;

		//y -
		ModelRenderer yl = new ModelRenderer(this, 0, 28);
		yl.addBox(-2, -4, -4, 4, 8, 8);
		yl.setRotationPoint(-8, -2, 8);
		yl.rotateAngleZ = (float) (Math.PI/2);
		cons[SIDE.getSideFromDir(ForgeDirection.DOWN)] = yl;
		
		//y +
		ModelRenderer ym = new ModelRenderer(this, 0, 28);
		ym.addBox(-2, -4, -4, 4, 8, 8);
		ym.setRotationPoint(-8, -14, 8);
		ym.rotateAngleZ = (float) (Math.PI/2);
		ym.rotateAngleY = (float) (Math.PI);
		cons[SIDE.getSideFromDir(ForgeDirection.UP)] = ym;
	}

	public void render(float mult, boolean[] cons){
		core.render(mult);
		
		for(int i = 0; i<cons.length; i++){
			if(cons[i]){
				this.cons[i].render(mult);
			}
		}
	}
}
