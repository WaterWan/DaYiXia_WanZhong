package main;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Hello {
	public Hello() {
		// ����һ������ռ�
		SimpleUniverse universe = new SimpleUniverse();
		// ����һ������������������ݽṹ
		BranchGroup group = new BranchGroup();

		// ����һ���򲢰������뵽group��
		Sphere sphere = new Sphere(0.5f); // С��İ뾶Ϊ0.5��
		group.addChild(sphere);

		Color3f light1Color = new Color3f(1.8f, 0.1f, 0.1f);
		// ���ù��ߵ���ɫ
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		// ���ù��ߵ����÷�Χ
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		// ���ù��ߵķ���
		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		// ָ����ɫ�ͷ��򣬲��������Դ
		light1.setInfluencingBounds(bounds);
		// �ѹ��ߵ����÷�Χ�����Դ��
		group.addChild(light1);
		// ����Դ����group��,���Ź۲��
		universe.getViewingPlatform().setNominalViewingTransform();
		// ��group���뵽����ռ���
		universe.addBranchGraph(group);
	}

	public static void main(String[] args) {
		new Hello();
	}
}
