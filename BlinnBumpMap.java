//(2)
abstract class BlinnBumpMap
{
	/** displaces normal vector. seeprevers*/
	final Vector3D displace(Vector2D dz, Direction U, Direction V, Normal N)
	{
		//seeprevers
		//Blinn
		Vector3D A = new Vector3D( N.external(U) );
		Vector3D B = new Vector3D( N.external(V) );
		Vector3D D = A.multiply(dz.u).subtract(B.multiply(dz.v));
		return N.add(D);

	};

	abstract Vector2D dZ(double u, double v);

	TextureMap map;

	final public void bump(Intersection i)
	{
		Vector2D uv = map.uv(i.intersectionPoint);
		Vector3D d=displace(dZ(uv.u,uv.v), map.U(i.intersectionPoint),map.V(i.intersectionPoint), i.normal);
		i.normal = new Normal(d);
	}
};
