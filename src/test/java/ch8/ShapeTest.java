package ch8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ShapeTest {

	@ParameterizedTest
	@MethodSource("getArguments")
	@DisplayName("Line, Oval, Rectangleについて、ファクトリメソッドにより作成されたインスタンスの検証を行う。")
	public void testShape(CreateShape createShape, int typeCode, String name, String draw) {
		var shape = createShape.apply(0, 1, 2, 3);
		assertThat(shape.getTypeCode()).isEqualTo(typeCode);
		assertThat(shape.getName()).isEqualTo(name);
		assertThat(shape.draw()).isEqualTo(draw);
	}
	
	public static Stream<Arguments> getArguments() {
		return Stream.of(
			arguments((CreateShape)Shape::createLine , 0, "LINE", "drawLine: [ LINE, (0, 1)-(2, 3) ]"),
			arguments((CreateShape)Shape::createRectangle , 1, "RECTANGLE", "drawRectangle: [ RECTANGLE, (0, 1)-(2, 3) ]"),
			arguments((CreateShape)Shape::createOval , 2, "OVAL", "drawOval: [ OVAL, (0, 1)-(2, 3) ]")
		);
	}
	
	
	@FunctionalInterface
	private interface CreateShape {
		Shape apply(int startX, int startY, int endX, int endY);
	}
}
