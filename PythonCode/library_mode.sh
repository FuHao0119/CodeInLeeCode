#!/bin/bash

# 图书馆静音模式 - 针对七彩虹 P15 优化
# 需使用 sudo 运行: sudo ./library_mode.sh

echo "正在进入图书馆静音模式..."

# 1. 锁定 CPU 频率上限为 1.2GHz (核心降温关键)
cpupower frequency-set -u 1.2GHz > /dev/null 2>&1

# 2. 设置能源偏好为极致省电 (EPP)
for i in /sys/devices/system/cpu/cpu*/cpufreq/energy_performance_preference; do
    echo "power" > "$i"
done

# 3. 彻底关闭 Intel 睿频 (Turbo Boost)
echo 1 > /sys/devices/system/cpu/intel_pstate/no_turbo

# 4. 切换 tuned 配置为省电
tuned-adm profile powersave > /dev/null 2>&1

# 5. 提示显卡切换 (因为需要重启，故仅做提示)
GPU_MODE=$(envycontrol --query)
if [ "$GPU_MODE" != "integrated" ]; then
    echo "--------------------------------------------------------"
    echo "提示: 当前显卡处于 $GPU_MODE 模式，仍在产生额外热量 (约 16W)。"
    echo "建议运行 'sudo envycontrol -s integrated' 并重启以获得极致静音。"
    echo "--------------------------------------------------------"
fi

echo "静音配置已完成！CPU 已锁定在低频，风扇应会保持安静。"
