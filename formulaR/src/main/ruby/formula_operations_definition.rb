# here operations of numeric types of java, 
# can be replaced by a best matematic formule style
# and another operations and syntax can be created
# as you wish

#Redefine BigDecimal operations  
class Java::JavaMath::BigDecimal
  
  def + (operand)
    execute_operation(operand, "add")
  end
  
  def - (operand)
    execute_operation(operand, "subtract")
  end
  
  def * (operand)
    execute_operation(operand, "multiply")      
  end
      
  def / (operand)
    execute_operation(operand, "divide")       
  end
  
  def sqrt(value)
    Math.sqrt(value)
  end
  
  def execute_operation (operand, java_operation)      
    if operand.kind_of?(Numeric)
      eval("self.#{java_operation}(Java::JavaMath::BigDecimal.new(#{operand}))") 
    elsif operand.is_a?(Java::JavaMath::BigDecimal)
      eval("self.#{java_operation}(#{operand})") 
    end  
  end
    
  def method_missing(name, *args)
    puts "The method #{name} doesn't exist in BigDecimal Java Class"
  end    
end

valor = Java::JavaMath::BigDecimal.new("5.0")
valor = valor - 2
puts valor

valor = valor + 3
puts valor
