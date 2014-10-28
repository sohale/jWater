class CheckerBW extends SimpleTexture2D
{
	public ColorRGB texture(double u, double v)
	{
		return
			((int)(u*2.0)+(int)(v*2.0))%2==0 ?
			Illumination.BLACK :
			Illumination.WHITE ;
	};
	//TextureMap map;
};
