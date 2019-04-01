################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../Blatt_1/main.c \
../Blatt_1/rechner.c 

OBJS += \
./Blatt_1/main.o \
./Blatt_1/rechner.o 

C_DEPS += \
./Blatt_1/main.d \
./Blatt_1/rechner.d 


# Each subdirectory must supply rules for building sources it contributes
Blatt_1/%.o: ../Blatt_1/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: Cross GCC Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


