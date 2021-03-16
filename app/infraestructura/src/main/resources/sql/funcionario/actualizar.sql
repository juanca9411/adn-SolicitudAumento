update funcionario
set nombre = :nombre,
	cedula = :cedula,
        salario = :salario,
	fechaNacimiento = :fechaNacimiento,
        fechaIngreso= :fechaIngreso
where idFuncionario = :idFuncionario