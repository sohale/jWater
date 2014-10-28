class Axial implements TextureMap
{
	Vector3D center;
	Direction normal;

	Axial(PointVector c, Direction n)
	{
		center = new Vector3D(c.x,c.y,c.z);
		normal = n;
	}
	public Direction U(SurfacePoint I)
	{
		//fetch V(I)
		return new Direction(V(I).external(normal));
	}
	public Direction V(SurfacePoint I)
	{
		Vector3D d=I.subtract(center);
		return new Direction(d.subtract(normal.multiply(normal.internal(d))));
	}
	public Vector2D uv(SurfacePoint I)
	{
		//seeprevers
		return new Vector2D(I.subtract(center).fromDirection(normal),0);
	}
}
