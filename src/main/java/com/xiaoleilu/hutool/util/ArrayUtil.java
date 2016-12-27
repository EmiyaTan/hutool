package com.xiaoleilu.hutool.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.xiaoleilu.hutool.exceptions.UtilException;
import com.xiaoleilu.hutool.lang.Editor;

/**
 * 数组工具类
 * 
 * @author Looly
 *
 */
public class ArrayUtil {

	// ---------------------------------------------------------------------- isEmpty
	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static <T> boolean isEmpty(final T[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final long[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final short[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final char[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final double[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final float[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为空
	 * 
	 * @param array 数组
	 * @return 是否为空
	 */
	public static boolean isEmpty(final boolean[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static <T> boolean isNotEmpty(final T[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final long[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final int[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final short[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final char[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final byte[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final double[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final float[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 数组是否为非空
	 * 
	 * @param array 数组
	 * @return 是否为非空
	 */
	public static boolean isNotEmpty(final boolean[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 新建一个空数组
	 * 
	 * @param componentType 元素类型
	 * @param newSize 大小
	 * @return 空数组
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<?> componentType, int newSize) {
		return (T[]) Array.newInstance(componentType, newSize);
	}

	/**
	 * 将新元素添加到已有数组中<br/>
	 * 添加新元素会生成一个新的数组，不影响原数组
	 * 
	 * @param buffer 已有数组
	 * @param newElements 新元素
	 * @return 新数组
	 */
	@SafeVarargs
	public static <T> T[] append(T[] buffer, T... newElements) {
		if (isEmpty(newElements)) {
			return buffer;
		}

		T[] t = resize(buffer, buffer.length + newElements.length);
		System.arraycopy(newElements, 0, t, buffer.length, newElements.length);
		return t;
	}

	/**
	 * 生成一个新的重新设置大小的数组
	 * 
	 * @param buffer 原数组
	 * @param newSize 新的数组大小
	 * @param componentType 数组元素类型
	 * @return 调整后的新数组
	 */
	public static <T> T[] resize(T[] buffer, int newSize, Class<?> componentType) {
		T[] newArray = newArray(componentType, newSize);
		if (isNotEmpty(buffer)) {
			System.arraycopy(buffer, 0, newArray, 0, Math.min(buffer.length, newSize));
		}
		return newArray;
	}

	/**
	 * 生成一个新的重新设置大小的数组<br/>
	 * 新数组的类型为原数组的类型
	 * 
	 * @param buffer 原数组
	 * @param newSize 新的数组大小
	 * @return 调整后的新数组
	 */
	public static <T> T[] resize(T[] buffer, int newSize) {
		return resize(buffer, newSize, buffer.getClass().getComponentType());
	}

	/**
	 * 将多个数组合并在一起<br>
	 * 忽略null的数组
	 * 
	 * @param arrays 数组集合
	 * @return 合并后的数组
	 */
	@SafeVarargs
	public static <T> T[] addAll(T[]... arrays) {
		if (arrays.length == 1) {
			return arrays[0];
		}

		int length = 0;
		for (T[] array : arrays) {
			if (array == null) {
				continue;
			}
			length += array.length;
		}
		T[] result = newArray(arrays.getClass().getComponentType().getComponentType(), length);

		length = 0;
		for (T[] array : arrays) {
			if (array == null) {
				continue;
			}
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * 克隆数组
	 * 
	 * @param array 被克隆的数组
	 * @return 新数组
	 */
	public static <T> T[] clone(T[] array) {
		if (array == null) {
			return null;
		}
		return array.clone();
	}

	/**
	 * 生成一个数字列表<br>
	 * 自动判定正序反序
	 * 
	 * @param excludedEnd 结束的数字（不包含）
	 * @return 数字列表
	 */
	public static int[] range(int excludedEnd) {
		return range(0, excludedEnd, 1);
	}

	/**
	 * 生成一个数字列表<br>
	 * 自动判定正序反序
	 * 
	 * @param includedStart 开始的数字（包含）
	 * @param excludedEnd 结束的数字（不包含）
	 * @return 数字列表
	 */
	public static int[] range(int includedStart, int excludedEnd) {
		return range(includedStart, excludedEnd, 1);
	}

	/**
	 * 生成一个数字列表<br>
	 * 自动判定正序反序
	 * 
	 * @param includedStart 开始的数字（包含）
	 * @param excludedEnd 结束的数字（不包含）
	 * @param step 步进
	 * @return 数字列表
	 */
	public static int[] range(int includedStart, int excludedEnd, int step) {
		if (includedStart > excludedEnd) {
			int tmp = includedStart;
			includedStart = excludedEnd;
			excludedEnd = tmp;
		}

		if (step <= 0) {
			step = 1;
		}

		int deviation = excludedEnd - includedStart;
		int length = deviation / step;
		if (deviation % step != 0) {
			length += 1;
		}
		int[] range = new int[length];
		for (int i = 0; i < length; i++) {
			range[i] = includedStart;
			includedStart += step;
		}
		return range;
	}

	/**
	 * 拆分byte数组
	 * 
	 * @param array 数组
	 * @param len 每个小节的长度
	 * @return 拆分后的数组
	 */
	public static byte[][] split(byte[] array, int len) {
		int x = array.length / len;
		int y = array.length % len;
		int z = 0;
		if (y != 0) {
			z = 1;
		}
		byte[][] arrays = new byte[x + z][];
		byte[] arr;
		for (int i = 0; i < x + z; i++) {
			arr = new byte[len];
			if (i == x + z - 1 && y != 0) {
				System.arraycopy(array, i * len, arr, 0, y);
			} else {
				System.arraycopy(array, i * len, arr, 0, len);
			}
			arrays[i] = arr;
		}
		return arrays;
	}

	/**
	 * 过滤
	 * 
	 * @param array 数组
	 * @param editor 编辑器接口
	 * @return 过滤后的数组
	 */
	public static <T> T[] filter(T[] array, Editor<T> editor) {
		ArrayList<T> list = new ArrayList<T>();
		T modified;
		for (T t : array) {
			modified = editor.edit(t);
			if (null != modified) {
				list.add(t);
			}
		}
		return list.toArray(Arrays.copyOf(array, list.size()));
	}

	/**
	 * 映射键值（参考Python的zip()函数）<br>
	 * 例如：<br>
	 * keys = [a,b,c,d]<br>
	 * values = [1,2,3,4]<br>
	 * 则得到的Map是 {a=1, b=2, c=3, d=4}<br>
	 * 如果两个数组长度不同，则只对应最短部分
	 * 
	 * @param keys 键列表
	 * @param values 值列表
	 * @return Map
	 */
	public static <T, K> Map<T, K> zip(T[] keys, K[] values) {
		if (isEmpty(keys) || isEmpty(values)) {
			return null;
		}

		final int size = Math.min(keys.length, values.length);
		final Map<T, K> map = new HashMap<T, K>((int) (size / 0.75));
		for (int i = 0; i < size; i++) {
			map.put(keys[i], values[i]);
		}

		return map;
	}

	/**
	 * 数组中是否包含元素
	 * 
	 * @param array 数组
	 * @param value 被检查的元素
	 * @return 是否包含
	 */
	public static <T> boolean contains(T[] array, T value) {
		final Class<?> componetType = array.getClass().getComponentType();
		boolean isPrimitive = false;
		if (null != componetType) {
			isPrimitive = componetType.isPrimitive();
		}
		for (T t : array) {
			if (t == value) {
				return true;
			} else if (false == isPrimitive && null != value && value.equals(t)) {
				return true;
			}
		}
		return false;
	}

	// ------------------------------------------------------------------- Wrap and unwrap
	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Integer[] wrap(int... values) {
		final int length = values.length;
		Integer[] array = new Integer[length];
		for (int i = 0; i < length; i++) {
			array[i] = Integer.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static int[] unWrap(Integer... values) {
		final int length = values.length;
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].intValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Long[] wrap(long... values) {
		final int length = values.length;
		Long[] array = new Long[length];
		for (int i = 0; i < length; i++) {
			array[i] = Long.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static long[] unWrap(Long... values) {
		final int length = values.length;
		long[] array = new long[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].longValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Character[] wrap(char... values) {
		final int length = values.length;
		Character[] array = new Character[length];
		for (int i = 0; i < length; i++) {
			array[i] = Character.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static char[] unWrap(Character... values) {
		final int length = values.length;
		char[] array = new char[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].charValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Byte[] wrap(byte... values) {
		final int length = values.length;
		Byte[] array = new Byte[length];
		for (int i = 0; i < length; i++) {
			array[i] = Byte.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static byte[] unWrap(Byte... values) {
		final int length = values.length;
		byte[] array = new byte[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].byteValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Short[] wrap(short... values) {
		final int length = values.length;
		Short[] array = new Short[length];
		for (int i = 0; i < length; i++) {
			array[i] = Short.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static short[] unWrap(Short... values) {
		final int length = values.length;
		short[] array = new short[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].shortValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Float[] wrap(float... values) {
		final int length = values.length;
		Float[] array = new Float[length];
		for (int i = 0; i < length; i++) {
			array[i] = Float.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static float[] unWrap(Float... values) {
		final int length = values.length;
		float[] array = new float[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].floatValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Double[] wrap(double... values) {
		final int length = values.length;
		Double[] array = new Double[length];
		for (int i = 0; i < length; i++) {
			array[i] = Double.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static double[] unWrap(Double... values) {
		final int length = values.length;
		double[] array = new double[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].doubleValue();
		}
		return array;
	}

	/**
	 * 将原始类型数组包装为包装类型
	 * 
	 * @param values 原始类型数组
	 * @return 包装类型数组
	 */
	public static Boolean[] wrap(boolean... values) {
		final int length = values.length;
		Boolean[] array = new Boolean[length];
		for (int i = 0; i < length; i++) {
			array[i] = Boolean.valueOf(values[i]);
		}
		return array;
	}

	/**
	 * 包装类数组转为原始类型数组
	 * 
	 * @param values 包装类型数组
	 * @return 原始类型数组
	 */
	public static boolean[] unWrap(Boolean... values) {
		final int length = values.length;
		boolean[] array = new boolean[length];
		for (int i = 0; i < length; i++) {
			array[i] = values[i].booleanValue();
		}
		return array;
	}

	/**
	 * 包装数组对象
	 * 
	 * @param obj 对象，可以是对象数组或者基本类型数组
	 * @return 包装类型数组或对象数组
	 * @throws UtilException 对象为非数组
	 */
	public static Object[] wrap(Object obj) {
		if (isArray(obj)) {
			try {
				return (Object[]) obj;
			} catch (Exception e) {
				final String className = obj.getClass().getComponentType().getName();
				switch (className) {
					case "long":
						return wrap((long[]) obj);
					case "int":
						return wrap((int[]) obj);
					case "short":
						return wrap((short[]) obj);
					case "char":
						return wrap((char[]) obj);
					case "byte":
						return wrap((byte[]) obj);
					case "boolean":
						return wrap((boolean[]) obj);
					case "float":
						return wrap((float[]) obj);
					case "double":
						return wrap((double[]) obj);
					default:
						throw new UtilException(e);
				}
			}
		}
		throw new UtilException(StrUtil.format("[{}] is not Array!", obj.getClass()));
	}

	/**
	 * 对象是否为数组对象
	 * 
	 * @param obj 对象
	 * @return 是否为数组对象
	 */
	public static boolean isArray(Object obj) {
		if (null == obj) {
			throw new NullPointerException("Object check for isArray is null");
		}
		return obj.getClass().isArray();
	}
	
	/**
	 * 数组或集合转String
	 * 
	 * @param obj 集合或数组对象
	 * @return 数组字符串，与集合转字符串格式相同
	 */
	public static String toString(Object obj) {
		if (null == obj) {
			return null;
		}
		if (ArrayUtil.isArray(obj)) {
			try {
				return Arrays.deepToString((Object[]) obj);
			} catch (Exception e) {
				final String className = obj.getClass().getComponentType().getName();
				switch (className) {
					case "long":
						return Arrays.toString((long[]) obj);
					case "int":
						return Arrays.toString((int[]) obj);
					case "short":
						return Arrays.toString((short[]) obj);
					case "char":
						return Arrays.toString((char[]) obj);
					case "byte":
						return Arrays.toString((byte[]) obj);
					case "boolean":
						return Arrays.toString((boolean[]) obj);
					case "float":
						return Arrays.toString((float[]) obj);
					case "double":
						return Arrays.toString((double[]) obj);
					default:
						throw new UtilException(e);
				}
			}
		}
		return obj.toString();
	}
}
