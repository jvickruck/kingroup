hold on

subplot(2,2,1)
f = f50
fb = f50b
% f_err = f50_err
hold
plot(x, f, '-k.', x, fb, ':k')
% legend('SIMPSON', 'DR', 4)
% errorbar(x, f, f_err, 'r-')
set(gca, 'XLim', [3, 17])
set(gca, 'YLim', [0, 100])
title('A. 50x1')
xlabel('\itN_L')
ylabel('Accuracy (%)')
%
subplot(2,2,2)
f = f5
fb = f5b
plot(x, f, '-k.', x, fb, ':k')
set(gca, 'XLim', [3, 17])
set(gca, 'YLim', [0, 100])
title('B. 5x10S')
ylabel('Accuracy (%)')
xlabel('\itN_L')
% %
subplot(2,2,3)
f = f25
fb = f25b
plot(x, f, '-k.', x, fb, ':k')
set(gca, 'XLim', [3, 17])
set(gca, 'YLim', [0, 100])
title('C. 25S (25-10-10-4-1)')
xlabel('\itN_L')
ylabel('Accuracy (%)')
% % grid on
% %
subplot(2,2,4)
f = f46
fb = f46b
plot(x, f, '-k.', x, fb, ':k')
% legend('DR (46P)', 4)
set(gca, 'XLim', [3, 17])
set(gca, 'YLim', [0, 100])
title('D. 46S (46-1-1-1-1)')
ylabel('Accuracy (%)')
xlabel('\itN_L')
% %
hold off